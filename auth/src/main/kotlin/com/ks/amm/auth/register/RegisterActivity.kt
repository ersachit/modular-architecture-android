package com.ks.amm.auth.register

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ks.amm.auth.R
import com.ks.amm.auth.databinding.ActivityRegisterBinding
import com.ks.amm.auth.model.Register

/**
 * Created by sachit on 19/12/17.
 */

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRegisterBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.register = Register("", "", "")

    }
}