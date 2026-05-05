package com.example.letssopt.presentation.user.signup

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object SignUp
@Composable
fun SignUpScreen(
    paddingValues: PaddingValues,
    SignUpClick: (name: String) -> Unit,
    /* viewModel: DViewModel = viewModel(), */
) {
}