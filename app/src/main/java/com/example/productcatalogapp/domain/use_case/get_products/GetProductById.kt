package com.example.productcatalogapp.domain.use_case.get_products

import com.example.productcatalogapp.domain.model.Product
import com.example.productcatalogapp.domain.repository.ProductRepository

class GetProductById(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int): Product {
        return repository.getProductById(id)
    }
}
