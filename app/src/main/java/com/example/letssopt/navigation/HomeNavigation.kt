package com.example.letssopt.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.presentation.home.HomeScreen
import com.example.letssopt.presentation.home.HomeViewModel

fun NavGraphBuilder.homeGraph(
    innerPadding: PaddingValues,
) {
    composable<Route.Home> {
        val viewModel: HomeViewModel = viewModel()

        HomeScreen(
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}