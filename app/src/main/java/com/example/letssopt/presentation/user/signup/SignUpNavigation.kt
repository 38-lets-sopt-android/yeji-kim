package com.example.letssopt.presentation.user.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.SignUp

fun NavGraphBuilder.signupGraph() {
    composable<SignUp> {
        SignUpScreen()
    }
}