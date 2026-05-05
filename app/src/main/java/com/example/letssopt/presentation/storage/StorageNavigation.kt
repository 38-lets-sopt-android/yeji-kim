package com.example.letssopt.presentation.storage

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Storage

fun NavGraphBuilder.storageGraph() {
    composable<Storage> {
        StorageScreen()
    }
}