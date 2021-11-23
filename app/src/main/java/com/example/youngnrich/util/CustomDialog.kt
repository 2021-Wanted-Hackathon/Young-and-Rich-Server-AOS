package com.example.youngnrich.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.youngnrich.databinding.CustomdialogAddPlannerBinding
import com.example.youngnrich.databinding.DialogLoadingBinding

class CustomDialog(context: Context) : Dialog(context) {
    private lateinit var binding: CustomdialogAddPlannerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = CustomdialogAddPlannerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window!!.setDimAmount(0.5f)
    }

    override fun show() {
        if(!this.isShowing) super.show()
    }
}