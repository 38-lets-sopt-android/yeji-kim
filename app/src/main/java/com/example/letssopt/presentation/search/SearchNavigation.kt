package com.example.letssopt.presentation.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Search

fun NavGraphBuilder.searchGraph() {
    composable<Search> {
        SearchScreen()
    }
}