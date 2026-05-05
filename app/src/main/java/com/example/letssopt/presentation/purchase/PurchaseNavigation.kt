package com.example.letssopt.presentation.purchase

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data object Purchase : MainTabRoute

fun NavGraphBuilder.purchaseGraph() {
    composable<Purchase> {
        PurchaseScreen()
    }
}