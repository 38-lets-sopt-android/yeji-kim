package com.example.letssopt.presentation.user.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Login

fun NavGraphBuilder.loginGraph(
    LoginSuccess: () -> Unit,
    SignUpClick: () -> Unit
) {
    composable<Login> {
        LoginScreen(
            loginSuccess = LoginSuccess,
            signUpClick = SignUpClick
        )
    }
}