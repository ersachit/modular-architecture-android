package com.ks.amm.product.catalog

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.ks.amm.product.ModularProduct
import com.ks.amm.product.R
import com.ks.amm.product.catalog.adapter.ProductAdapter
import com.ks.amm.product.catalog.model.Product
import com.ks.amm.product.details.ProductDetailsActivity
import kotlinx.android.synthetic.main.activity_product_catalog.*


class ProductCatalogActivity: AppCompatActivity() {
    private lateinit var productContainer: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_catalog)
        productContainer = product_container as RecyclerView
        initToolbar()
        initData()
    }

    private fun initToolbar() {
        val toolbar: Toolbar = toolbar as Toolbar
        setSupportActionBar(toolbar)
    }

    private fun initData() {
        product_container.layoutManager = GridLayoutManager(this, 2)
        product_container.adapter = ProductAdapter(getData(), { position ->
            val product = getAdapter().getItem(position)
            val intent = Intent(this@ProductCatalogActivity, ProductDetailsActivity::class.java)
            intent.putExtra(ProductDetailsActivity.EXTRA_PRODUCT, product)
            startActivity(intent)
        })
    }

    private fun getAdapter() : ProductAdapter {
        return product_container.adapter as ProductAdapter
    }

    private fun getData(): MutableList<Product> {
        return mutableListOf(
            Product("GreenFence 1", "", 10000),
            Product("GreenFence 2", "", 20000),
            Product("GreenFence 3", "", 30000),
            Product("GreenFence 4", "", 40000)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_product, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.action_cart -> ModularProduct.getInstance().buyActionListener?.onShoppingCartActionClicked()
        }
        return super.onOptionsItemSelected(item)
    }
}