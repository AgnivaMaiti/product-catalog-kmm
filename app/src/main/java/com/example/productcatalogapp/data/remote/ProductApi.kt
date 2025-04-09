package com.example.productcatalogapp.data.remote

import com.example.productcatalogapp.data.remote.dto.ProductDto
import com.example.productcatalogapp.data.remote.dto.ProductListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object ProductApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getProducts(): ProductListResponse {
        return client.get("https://dummyjson.com/products").body()
    }

    suspend fun getProductById(id: Int): ProductDto {
        return client.get("https://dummyjson.com/products/$id").body()
    }
}
