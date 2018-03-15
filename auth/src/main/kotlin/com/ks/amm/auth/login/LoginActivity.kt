package com.ks.amm.auth.login

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ks.amm.auth.R
import com.ks.amm.auth.databinding.ActivityLoginBinding
import com.ks.amm.auth.model.UserLogin


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.user    =   UserLogin("","")

//        login_button.setOnClickListener {
//            ModularAuth.getInstance().loginListener?.onLoginSuccess()
//            ModularAuth.getInstance().authDataHandler.setLoggedIn(true)
//            finish()
//        }
    }


    fun doLogin(name: String, password: String) {
        if (name.isEmpty()) {
            return
        }
        if (password.isEmpty()) {
            return
        }
    }
}