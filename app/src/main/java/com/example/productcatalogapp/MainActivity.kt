package com.example.productcatalogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.productcatalogapp.presentation.navigation.NavGraph
import com.example.productcatalogapp.ui.theme.ProductCatalogAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductCatalogAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}
