package com.example.letssopt.presentation.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data object Search : MainTabRoute

fun NavGraphBuilder.searchGraph() {
    composable<Search> {
        SearchScreen()
    }
}