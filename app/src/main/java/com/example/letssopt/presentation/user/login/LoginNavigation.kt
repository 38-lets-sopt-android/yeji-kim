package com.example.letssopt.presentation.user.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import com.example.letssopt.presentation.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object Login : MainTabRoute

fun NavGraphBuilder.loginGraph() {
    composable<Login> {
        HomeScreen()
    }
}