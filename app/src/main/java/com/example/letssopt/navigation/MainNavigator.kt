package com.example.letssopt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTab: Int
        @Composable get() = when {
            currentDestination?.hasRoute<Route.Home>() == true -> 0
            currentDestination?.hasRoute<Route.Purchase>() == true -> 1
            currentDestination?.hasRoute<Route.Webtoon>() == true -> 2
            currentDestination?.hasRoute<Route.Search>() == true -> 3
            currentDestination?.hasRoute<Route.Storage>() == true -> 4
            else -> 0
        }

    fun navigateTo(index: Int) {
        val route = when (index) {
            0 -> Route.Home
            1 -> Route.Purchase
            2 -> Route.Webtoon
            3 -> Route.Search
            4 -> Route.Storage
            else -> Route.Home
        }
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}