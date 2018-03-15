package com.ks.amm

import android.app.Application
import com.ks.amm.auth.ModularAuth
import com.ks.amm.product.ModularProduct


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initModularAuth()
        initModularProduct()
    }

    private fun initModularAuth() {
        ModularAuth.Builder(this)
            .build()
    }

    private fun initModularProduct(){
        ModularProduct.Builder(this)
            .build()
    }

}