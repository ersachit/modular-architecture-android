package com.ks.amm.auth.login

interface LoginResultListener {
    fun onLoginSuccess()
    fun onLoginFailure()
}