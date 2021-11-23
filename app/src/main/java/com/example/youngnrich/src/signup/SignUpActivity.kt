package com.example.youngnrich.src.signup

import android.content.Intent
import android.os.Bundle
import com.example.youngnrich.R
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivitySignupBinding
import com.example.youngnrich.src.login.LoginActivity

class SignUpActivity : BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)

        binding.signupConst8.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.signupConst1Img1.setOnClickListener(){
            onBackPressed()
        }
    }

    override fun finish(){
        super.finish()
        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}