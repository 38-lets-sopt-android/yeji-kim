package com.example.letssopt.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.presentation.user.login.LoginScreen

fun NavGraphBuilder.loginGraph(
    innerPadding: PaddingValues,
) {
    composable<Route.Login> {
        LoginScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}