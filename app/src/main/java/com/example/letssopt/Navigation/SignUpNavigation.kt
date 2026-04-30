package com.example.letssopt.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.presentation.user.SignUpScreen

fun NavGraphBuilder.signupGraph(
    innerPadding: PaddingValues,
) {
    composable<Route.SignUp> {
        SignUpScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}