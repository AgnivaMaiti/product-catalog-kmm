package com.example.productcatalogapp.presentation.product_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productcatalogapp.data.remote.ProductApi
import com.example.productcatalogapp.data.remote.dto.toProduct
import com.example.productcatalogapp.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val _state = MutableStateFlow(ProductListState())
    val state: StateFlow<ProductListState> = _state

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _state.value = ProductListState(isLoading = true)
            try {
                val response = ProductApi.getProducts()
                val products = response.products.map { it.toProduct() }
                _state.value = ProductListState(products = products)
            } catch (e: Exception) {
                _state.value = ProductListState(error = "Something went wrong: ${e.message}")
            }
        }
    }
}
