package com.example.youngnrich.src.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.youngnrich.databinding.ActivityHomeBinding
import com.example.youngnrich.databinding.CashItemBinding
import com.example.youngnrich.databinding.PlannerlistItemBinding

class PlannerListAdapter(private val context: Context, var plannerArrayList: MutableList<plannerlist>) :
    RecyclerView.Adapter<PlannerListAdapter.ItemViewHolder>() {
    //Layout들과 RecyclerView를 연결시킬 Adapter(데이터를 받아오고 이를 레이아웃에 직접 연결하는 함수를 실행시키는 클래스)


    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }
    private lateinit var itemClickListener: ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    fun addItem(plannerlist: plannerlist){
        plannerArrayList.add(plannerlist)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val binding: PlannerlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plannerlist: plannerlist, num: Int, context: Context) {

            binding.plannerListItemTxt1.text = plannerlist.tag2
            binding.plannerListItemTxt2.text = "${plannerlist.price}원 "
            binding.plannerListItemTxt3.text = "/ ${plannerlist.price2}원 "
        }
    } //ViewHolder는 클래스 내에 View를 저장하는 변수를 만들어 그 안에 데이터를 직접 연결시킬 수 있는 클래스, 디자인 패턴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = PlannerlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    } //화면을 최초 로딩하여 만들어진 View가 없는 경우 레이아웃을 inflate하여 viewHolder를 생성

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(plannerArrayList[position], position, context)

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
            //val intent = Intent(holder.itemView?.context, RestaurantListActivity::class.java)
            //ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    } //layout의 view와 데이터를 연결

    override fun getItemCount(): Int {
        return plannerArrayList.size
    }
} //아이템 갯수를 리턴처리하면 된다.