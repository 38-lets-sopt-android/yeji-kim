package com.example.letssopt.presentation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Search

fun NavController.navigateToSearch(navOptions: NavOptions) = navigate(Search, navOptions)
fun NavGraphBuilder.searchGraph() {
    composable<Search> {
        SearchScreen()
    }
}