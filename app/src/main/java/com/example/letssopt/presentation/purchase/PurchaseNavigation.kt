package com.example.letssopt.presentation.purchase

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Purchase

fun NavGraphBuilder.purchaseGraph() {
    composable<Purchase> {
        PurchaseScreen()
    }
}