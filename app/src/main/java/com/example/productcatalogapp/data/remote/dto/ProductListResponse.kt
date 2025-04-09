package com.example.productcatalogapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    val products: List<ProductDto>
)

