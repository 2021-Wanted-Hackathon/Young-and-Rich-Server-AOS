package com.example.youngnrich.src.plannerlist_detail

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youngnrich.R
import com.example.youngnrich.config.ApplicationClass.Companion.sSharedPreferences
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityPlannerlistDetailBinding
import com.example.youngnrich.src.plannerlist.PlannerList2Adapter
import com.example.youngnrich.src.plannerlist.plannerlist2

data class plannerlistdate(val date : String, val tag: String, val price : Int, val group: Int)

class PlannerListDetailActivity : BaseActivity<ActivityPlannerlistDetailBinding>(ActivityPlannerlistDetailBinding::inflate) {
    var plannerlistDate = mutableListOf<plannerlistdate>()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.plannerlistDetailConst1Txt1.text = sSharedPreferences.getString("planner_tag", null)
        val PlannerListDetailAdapter = PlannerListDetailAdapter(this, plannerlistDate)
        binding.plannerlistDetailConst2Rcyc1.adapter = PlannerListDetailAdapter

        val layout2 = LinearLayoutManager(this)
        binding.plannerlistDetailConst2Rcyc1.layoutManager = layout2
        binding.plannerlistDetailConst2Rcyc1.setHasFixedSize(true)

        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.30","", 0,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","(주)이디야", 3800,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("","스타벅스", 5000,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("","언니네주막", 10000,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.28","", 0,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","GS25", 1200,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.25","", 2000,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","고수찜닭", 19000,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("","CU", 1300,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.23","", 5000,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","티머니", 30000,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.18","", 1000,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","인터파크", 25000,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.15","", 4000,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","배달의민족", 15000,1))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.10","", 30000,0))
        PlannerListDetailAdapter.addItem(plannerlistdate("","쿠팡이츠", 21000,1))
        PlannerListDetailAdapter.notifyDataSetChanged()


    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}