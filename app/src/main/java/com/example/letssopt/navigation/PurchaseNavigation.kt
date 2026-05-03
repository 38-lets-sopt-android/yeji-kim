package com.example.letssopt.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.presentation.purchase.PurchaseScreen

fun NavGraphBuilder.purchaseGraph(
    innerPadding: PaddingValues,
) {
    composable<Route.Purchase> {
        PurchaseScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}