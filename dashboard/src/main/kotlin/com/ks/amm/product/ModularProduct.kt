package com.ks.amm.product

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.ks.amm.product.catalog.ProductCatalogActivity


class ModularProduct private constructor(builder: Builder){
    companion object {
        private var INSTANCE: ModularProduct? = null

        fun getInstance() : ModularProduct {
            return INSTANCE?: throw RuntimeException("ModularProduct isn't initialized.")
        }
    }

    var context: Context
    var buyActionListener: ProductActionListener? = null

    init {
        context = builder.context

        INSTANCE = this
    }

    /**
     * Start product catalog page.
     */
    fun startProductCatalog(activity: Activity, buyActionListener: ProductActionListener) {
        this.buyActionListener = buyActionListener
        activity.startActivity(Intent(activity, ProductCatalogActivity::class.java))
    }

    class Builder(val context: Context) {
        fun build() = ModularProduct(this)
    }
}