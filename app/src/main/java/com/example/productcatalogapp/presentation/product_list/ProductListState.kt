package com.example.productcatalogapp.presentation.product_list

import com.example.productcatalogapp.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
