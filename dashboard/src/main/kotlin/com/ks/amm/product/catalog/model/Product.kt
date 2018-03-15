package com.ks.amm.product.catalog.model

import java.io.Serializable

data class Product(val name: String,
                   val image: String,
                   val price: Int) : Serializable