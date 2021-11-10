package com.example.youngnrich.src.plannerlist

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youngnrich.R
import com.example.youngnrich.config.ApplicationClass.Companion.sSharedPreferences
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityPlannerlistBinding
import com.example.youngnrich.src.home.PlannerListAdapter
import com.example.youngnrich.src.home.plannerlist
import com.example.youngnrich.util.CustomDialog

data class plannerlist2(val tag2 : String)

class PlannerListActivity : BaseActivity<ActivityPlannerlistBinding>(ActivityPlannerlistBinding::inflate) {

    var plannerList2 = mutableListOf<plannerlist2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val plannerlist2Adapter = PlannerList2Adapter(this,plannerList2)
        binding.plannerlistConst2Rcyc1.adapter = plannerlist2Adapter

        val layout2 = LinearLayoutManager(this)
        layout2.orientation = LinearLayoutManager.VERTICAL
        binding.plannerlistConst2Rcyc1.layoutManager = layout2
        binding.plannerlistConst2Rcyc1.setHasFixedSize(true)

        plannerlist2Adapter.setItemClickListener(object : PlannerList2Adapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = plannerList2[position]
                val preferencesEditor: SharedPreferences.Editor = sSharedPreferences.edit()
                preferencesEditor.putString("planner_tag",item.tag2)
                preferencesEditor.apply()
            }
        })
        plannerlist2Adapter.addItem(plannerlist2("식비"))
        plannerlist2Adapter.addItem(plannerlist2("쇼핑"))
        plannerlist2Adapter.addItem(plannerlist2("교통"))
        plannerlist2Adapter.addItem(plannerlist2("카페"))
        plannerlist2Adapter.addItem(plannerlist2("문화"))
        plannerlist2Adapter.addItem(plannerlist2("생활"))
        plannerlist2Adapter.addItem(plannerlist2("주거"))
        plannerlist2Adapter.addItem(plannerlist2("건강"))
        plannerlist2Adapter.addItem(plannerlist2("기타"))

        plannerlist2Adapter.notifyDataSetChanged()

        binding.plannerlistLinear1.setOnClickListener(){
            val dialog = CustomDialog(this)
            dialog.show()
        }
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}