package com.example.letssopt.presentation.user.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data object Login : MainTabRoute

fun NavGraphBuilder.loginGraph(
    LoginSuccess: (String) -> Unit
) {
    composable<Login> {
        LoginScreen(
            loginSuccess = LoginSuccess,
            signUpClick = {}
        )
    }
}