package com.example.youngnrich.src.plannerlist_detail

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.youngnrich.databinding.*
import com.example.youngnrich.src.home.plannerlist
import com.example.youngnrich.src.plannerlist.plannerlist2
import com.example.youngnrich.src.plannerlist_detail.PlannerListDetailActivity

class PlannerListDetailAdapter(private val context: Context, var plannerdateArrayList: MutableList<plannerlistdate>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)
    private val VIEW_TYPE_DATE = 1
    private val VIEW_TYPE_LIST = 0

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun addItem(plannerlistdate: plannerlistdate){
        plannerdateArrayList.add(plannerlistdate)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val binding: UserlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plannerlistdate: plannerlistdate, num: Int, context: Context) {

            binding.userlistItemConst1Txt1.text = plannerlistdate.tag
            binding.userlistItemConst1Txt2.text = "${plannerlistdate.price}원"
        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    inner class ItemViewHolder2(private val binding: UserlistItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plannerlistdate: plannerlistdate, num: Int, context: Context) {

            binding.userlistItem2Txt1.text = plannerlistdate.date
        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            VIEW_TYPE_LIST -> {
                val binding = UserlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding)
            }

            VIEW_TYPE_DATE -> {
                val binding = UserlistItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder2(binding)
            }

            else -> {
                val binding = UserlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemViewHolder(binding)
            }
        }
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ItemViewHolder) {
            holder.bind(plannerdateArrayList[position], position, context)
        }
        else if(holder is ItemViewHolder2){
            holder.bind(plannerdateArrayList[position], position, context)
        }

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
            val intent = Intent(holder.itemView?.context, PlannerListDetailActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return plannerdateArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        // 게시물과 프로그레스바 아이템뷰를 구분할 기준이 필요하다.
        return when (plannerdateArrayList[position].group) {
            1 -> VIEW_TYPE_LIST
            0 -> VIEW_TYPE_DATE
            else -> VIEW_TYPE_LIST
        }
    }} //아이템 갯수를 리턴처리하면 된다.