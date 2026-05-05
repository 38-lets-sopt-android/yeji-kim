package com.example.letssopt.presentation.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Home
import com.example.letssopt.presentation.home.HomeScreen

fun NavGraphBuilder.homeGraph() {
    composable<Home> {
        HomeScreen()
    }
}