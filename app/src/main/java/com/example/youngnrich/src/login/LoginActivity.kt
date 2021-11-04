package com.example.youngnrich.src.login

import android.content.Intent
import android.os.Bundle
import com.example.youngnrich.R
import com.example.youngnrich.config.BaseActivity
import com.example.youngnrich.databinding.ActivityLoginBinding
import com.example.youngnrich.src.home.HomeActivity
import com.example.youngnrich.src.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_in_right, R.anim.none)
        super.onCreate(savedInstanceState)


        binding.loginConst4.setOnClickListener(){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        binding.loginConst5Txt3.setOnClickListener(){
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    override fun finish(){
        super.finish()

        overridePendingTransition(R.anim.none, R.anim.slide_out_right)
    }
}