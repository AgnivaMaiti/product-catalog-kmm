package com.example.productcatalogapp.di

import com.example.productcatalogapp.data.remote.ProductApi
import com.example.productcatalogapp.data.repository.ProductRepositoryImpl
import com.example.productcatalogapp.domain.repository.ProductRepository
import com.example.productcatalogapp.domain.use_case.get_products.GetProductById
import com.example.productcatalogapp.domain.use_case.get_products.GetProducts
import com.example.productcatalogapp.domain.use_case.get_products.ProductUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://dummyjson.com/"

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideProductUseCases(repository: ProductRepository): ProductUseCases {
        return ProductUseCases(
            getProducts = GetProducts(repository),
            getProductById = GetProductById(repository)
        )
    }
}
