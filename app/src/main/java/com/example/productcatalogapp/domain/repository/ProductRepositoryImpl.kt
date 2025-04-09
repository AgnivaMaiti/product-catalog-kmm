package com.example.productcatalogapp.data.repository

import com.example.productcatalogapp.data.remote.ProductApi
import com.example.productcatalogapp.data.remote.dto.toProduct
import com.example.productcatalogapp.domain.model.Product
import com.example.productcatalogapp.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return api.getProducts().products.map { it.toProduct() }
    }

    override suspend fun getProductById(id: Int): Product {
        return api.getProductById(id).toProduct()
    }
}
