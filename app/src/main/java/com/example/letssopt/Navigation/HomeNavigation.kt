package com.example.letssopt.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.component.Route

fun NavController.navigateToHome(navOptions: NavOptions) = navigate(Route.Home, navOptions)

fun NavGraphBuilder.homeGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Route.Home> {
        HomeRoute(
            paddingValues = innerPadding,
        )
    }
}