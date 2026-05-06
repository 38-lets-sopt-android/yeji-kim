package com.example.letssopt.presentation.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Home
import com.example.letssopt.presentation.home.HomeScreen

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(Home, navOptions)

fun NavGraphBuilder.homeGraph() {
    composable<Home> {
        HomeScreen()
    }
}