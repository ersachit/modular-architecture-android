package com.ks.amm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ks.amm.auth.ModularAuth
import com.ks.amm.auth.login.LoginResultListener
import com.ks.amm.auth.register.RegisterResultListener
import com.ks.amm.product.ModularProduct
import com.ks.amm.product.ProductActionListener
import com.ks.amm.product.catalog.model.Product


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkIfUserIsAlreadyLoggedIn()
    }

    private fun checkIfUserIsAlreadyLoggedIn() {
        if (ModularAuth.getInstance().isLoggedIn()) {
            startProductCatalog()

        } else {
            ModularAuth.getInstance().startRegisterPage(this, object : RegisterResultListener {

                override fun onRegisterSuccess() {
                    startProductCatalog()
                }

                override fun onRegisterFailure() {
                }
            })


        }
    }

    private fun startProductCatalog() {
        ModularProduct.getInstance().startProductCatalog(this, object : ProductActionListener {

            override fun onProductBuyActionClicked(product: Product) {

            }

            override fun onShoppingCartActionClicked() {

            }
        })
    }

}