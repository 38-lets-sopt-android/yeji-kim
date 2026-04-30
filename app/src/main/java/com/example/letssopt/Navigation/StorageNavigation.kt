package com.example.letssopt.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.presentation.storage.StorageScreen

fun NavGraphBuilder.storageGraph(
    innerPadding: PaddingValues,
) {
    composable<Route.Storage> {
        StorageScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}