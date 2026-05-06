package com.example.letssopt.presentation.purchase

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Purchase

fun NavController.navigateToPurchase(navOptions: NavOptions) = navigate(Purchase, navOptions)

fun NavGraphBuilder.purchaseGraph() {
    composable<Purchase> {
        PurchaseScreen()
    }
}