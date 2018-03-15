package com.ks.amm.product

import com.ks.amm.product.catalog.model.Product


interface ProductActionListener {
    fun onProductBuyActionClicked(product: Product)
    fun onShoppingCartActionClicked()
}