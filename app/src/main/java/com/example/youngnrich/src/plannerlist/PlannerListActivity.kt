package com.example.youngnrich.src.plannerlist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youngnrich.R
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityPlannerlistBinding
import com.example.youngnrich.src.home.PlannerListAdapter
import com.example.youngnrich.src.home.plannerlist
import com.example.youngnrich.util.CustomDialog

data class plannerlist2(val tag2 : String, val price : Int)

class PlannerListActivity : BaseActivity<ActivityPlannerlistBinding>(ActivityPlannerlistBinding::inflate) {

    var plannerList2 = mutableListOf<plannerlist2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val plannerlist2Adapter = PlannerList2Adapter(this,plannerList2)
        binding.plannerlistConst2Rcyc1.adapter = plannerlist2Adapter

        val layout2 = LinearLayoutManager(this)
        binding.plannerlistConst2Rcyc1.layoutManager = layout2
        binding.plannerlistConst2Rcyc1.setHasFixedSize(true)

        plannerlist2Adapter.setItemClickListener(object : PlannerList2Adapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
            }
        })
        plannerlist2Adapter.addItem(plannerlist2("쇼핑", 50000))
        plannerlist2Adapter.addItem(plannerlist2("교통", 5000))
        plannerlist2Adapter.addItem(plannerlist2("레저", 30000))
        plannerlist2Adapter.addItem(plannerlist2("여행", 20000))

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