package com.ks.amm.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.ks.amm.auth.data.AuthDataHandler
import com.ks.amm.auth.login.LoginActivity
import com.ks.amm.auth.login.LoginResultListener
import com.ks.amm.auth.register.RegisterActivity
import com.ks.amm.auth.register.RegisterResultListener
import com.ks.amm.utils.PreferenceHelper


class ModularAuth private constructor(builder: Builder){
    companion object {
        private var INSTANCE : ModularAuth? = null

        fun getInstance(): ModularAuth {
            return INSTANCE?: throw RuntimeException("ModularAuth isn't initialized.")
        }
    }

    val context: Context
    val authDataHandler: AuthDataHandler
    var loginListener: LoginResultListener? = null
    var registerListener: RegisterResultListener? = null

    init {
        context = builder.context
        authDataHandler = AuthDataHandler(PreferenceHelper(builder.context))

        INSTANCE = this
    }

    /**
     * Start login page.
     */
    fun startLoginPage(activity: Activity, loginResultListener: LoginResultListener) {
        this.loginListener = loginResultListener
        activity.startActivity(Intent(context, LoginActivity::class.java))
    }

    /**
     * Start register page.
     */
    fun startRegisterPage(activity: Activity, registerResultListener: RegisterResultListener) {
        this.registerListener = registerResultListener
        activity.startActivity(Intent(context, RegisterActivity::class.java))
    }


    /**
     * Check if user is already logged in.
     */
    fun isLoggedIn(): Boolean {
        return authDataHandler.isLoggedIn()
    }

    class Builder(val context: Context) {
        fun build() = ModularAuth(this)
    }
}