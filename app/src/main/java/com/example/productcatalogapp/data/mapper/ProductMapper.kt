package com.example.productcatalogapp.data.mapper

import com.example.productcatalogapp.data.remote.dto.ProductDto
import com.example.productcatalogapp.domain.model.Product

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        price = price,
        thumbnail = thumbnail
    )
}
