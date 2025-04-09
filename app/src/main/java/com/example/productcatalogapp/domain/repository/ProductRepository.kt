package com.example.productcatalogapp.domain.repository

import com.example.productcatalogapp.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProductById(id: Int): Product
}
