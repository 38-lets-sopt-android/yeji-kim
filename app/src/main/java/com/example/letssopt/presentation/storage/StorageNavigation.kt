package com.example.letssopt.presentation.storage

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data object Storage : MainTabRoute

fun NavGraphBuilder.storageGraph() {
    composable<Storage> {
        StorageScreen()
    }
}