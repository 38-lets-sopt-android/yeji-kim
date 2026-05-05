package com.example.letssopt.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import com.example.letssopt.presentation.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object Home : MainTabRoute

fun NavGraphBuilder.homeGraph() {
    composable<Home> {
        HomeScreen()
    }
}