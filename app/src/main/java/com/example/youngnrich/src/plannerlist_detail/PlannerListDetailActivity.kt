package com.example.youngnrich.src.plannerlist_detail

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youngnrich.R
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityPlannerlistDetailBinding
import com.example.youngnrich.src.plannerlist.PlannerList2Adapter
import com.example.youngnrich.src.plannerlist.plannerlist2

data class plannerlistdate(val date : String, val tag: String, val price : Int)

class PlannerListDetailActivity : BaseActivity<ActivityPlannerlistDetailBinding>(ActivityPlannerlistDetailBinding::inflate) {
    val plannerlistDate = mutableListOf<plannerlistdate>()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val PlannerListDetailAdapter = PlannerListDetailAdapter(this, plannerlistDate)
        binding.plannerlistDetailConst2Rcyc1.adapter = PlannerListDetailAdapter

        val layout2 = LinearLayoutManager(this)
        binding.plannerlistDetailConst2Rcyc1.layoutManager = layout2
        binding.plannerlistDetailConst2Rcyc1.setHasFixedSize(true)

        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.30","쇼핑", 5000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.28","레저", 3000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.27","여행", 5000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.25","쇼핑", 2000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.23","쇼핑", 50000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.20","여행", 5000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.18","교통", 1000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.15","쇼핑", 4000))
        PlannerListDetailAdapter.addItem(plannerlistdate("2021.10.10","교통", 30000))

        PlannerListDetailAdapter.notifyDataSetChanged()
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}