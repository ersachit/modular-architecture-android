package com.ks.amm.auth.data

import com.ks.amm.utils.PreferenceHelper


class AuthDataHandler(private val preferenceHelper: PreferenceHelper) {
    companion object {
        private const val KEY_IS_LOGGED_IN = "is.logged.in"
    }

    fun isLoggedIn(): Boolean {
        return preferenceHelper.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setLoggedIn(loggedIn: Boolean) {
        preferenceHelper.putBoolean(KEY_IS_LOGGED_IN, loggedIn)
    }
}