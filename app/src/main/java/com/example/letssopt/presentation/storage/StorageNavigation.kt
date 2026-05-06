package com.example.letssopt.presentation.storage

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Storage

fun NavController.navigateToStorage(navOptions: NavOptions) = navigate(Storage, navOptions)
fun NavGraphBuilder.storageGraph() {
    composable<Storage> {
        StorageScreen()
    }
}