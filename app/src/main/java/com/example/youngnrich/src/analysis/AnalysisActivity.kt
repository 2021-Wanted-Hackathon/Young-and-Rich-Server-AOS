package com.example.youngnrich.src.analysis

import android.os.Bundle
import com.example.youngnrich.R
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityAnalysisBinding

class AnalysisActivity : BaseActivity<ActivityAnalysisBinding>(ActivityAnalysisBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)
    }

    override fun finish(){
        super.finish()
        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}