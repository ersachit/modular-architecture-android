package com.ks.amm.product.details

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import com.ks.amm.product.ModularProduct
import com.ks.amm.product.R
import com.ks.amm.product.catalog.model.Product
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PRODUCT = "extra.product"
    }

    private val product: Product by lazy { intent.getSerializableExtra(EXTRA_PRODUCT) as Product }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val toolbar = toolbar as Toolbar
        toolbar.title = product.name

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fab = fab as FloatingActionButton

        fab.setOnClickListener { view ->
            Snackbar
                    .make(view, "Product has been added to favorite list", Snackbar.LENGTH_LONG)
                    .show()
        }

        val buyButton = buy_button as Button
        buyButton.setOnClickListener { view ->
            val buyActionListener = ModularProduct.getInstance().buyActionListener
            if (buyActionListener != null) {
                buyActionListener.onProductBuyActionClicked(product)
            } else {
                Snackbar
                        .make(view, "Product buy action isn't implemented.", Snackbar.LENGTH_LONG)
                        .show()
            }
        }
    }
}