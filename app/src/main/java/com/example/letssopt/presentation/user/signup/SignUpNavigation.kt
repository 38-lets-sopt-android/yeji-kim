package com.example.letssopt.presentation.user.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.navigation.SignUp

fun NavGraphBuilder.signupGraph(
    onSignUpSuccess: () -> Unit
) {
    composable<SignUp> {
        SignUpScreen(onSignUpSuccess = onSignUpSuccess)
    }
}