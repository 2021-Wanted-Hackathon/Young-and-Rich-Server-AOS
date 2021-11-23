package com.example.youngnrich.src.home

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youngnrich.R
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityHomeBinding
import com.example.youngnrich.src.plannerlist.PlannerListActivity

data class banklist(val tag : String, val cash : Int)
data class plannerlist(val tag2 : String, val price : Int)

class HomeActivity : BaseActivity<ActivityHomeBinding>(ActivityHomeBinding::inflate) {
    var bankList = mutableListOf<banklist>()
    var plannerList = mutableListOf<plannerlist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        val banklistAdapter = BankListAdapter(this, bankList)
        binding.homeConst2Rcyc1.adapter = banklistAdapter

        val plannerlistAdapter = PlannerListAdapter(this,plannerList)
        binding.homeConst3Rcyc1.adapter = plannerlistAdapter

        val layout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.homeConst2Rcyc1.layoutManager = layout
        binding.homeConst2Rcyc1.setHasFixedSize(true)

        val layout2 = LinearLayoutManager(this)
        binding.homeConst3Rcyc1.layoutManager = layout2
        binding.homeConst3Rcyc1.setHasFixedSize(true)

        banklistAdapter.addItem(banklist("전체잔액", 2000000))
        banklistAdapter.addItem(banklist("국민은행", 500000))
        banklistAdapter.addItem(banklist("카카오뱅크", 7000000))
        banklistAdapter.addItem(banklist("IBK기업은행", 7000000))
        banklistAdapter.notifyDataSetChanged()

        plannerlistAdapter.addItem(plannerlist("쇼핑", 50000))
        plannerlistAdapter.addItem(plannerlist("교통", 5000))
        plannerlistAdapter.addItem(plannerlist("레저", 30000))
        plannerlistAdapter.addItem(plannerlist("여행", 20000))
        plannerlistAdapter.notifyDataSetChanged()

        binding.homeConst3Img1.setOnClickListener(){
            startActivity(Intent(this, PlannerListActivity::class.java))
            finish()
        }
    }

    override fun finish(){
        super.finish()
        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}