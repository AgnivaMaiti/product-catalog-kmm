package com.example.productcatalogapp.presentation.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productcatalogapp.domain.model.Product
import com.example.productcatalogapp.data.remote.ProductApi
import com.example.productcatalogapp.data.remote.dto.toProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {

    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun loadProduct(productId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val productDto = ProductApi.getProductById(productId)
                _product.value = productDto.toProduct()
            } catch (e: Exception) {
                _error.value = e.localizedMessage ?: "Error loading product"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
