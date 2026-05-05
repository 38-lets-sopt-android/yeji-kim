package com.example.letssopt.presentation.user.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object Login

@Composable
fun LoginScreen(
    paddingValues: PaddingValues,
    LoginSuccess: (name: String) -> Unit,
    /* viewModel: DViewModel = viewModel(), */
) {
}