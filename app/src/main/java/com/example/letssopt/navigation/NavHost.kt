package com.example.letssopt.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.letssopt.presentation.home.navigation.homeGraph
import com.example.letssopt.presentation.main.component.MainAppState
import com.example.letssopt.presentation.purchase.purchaseGraph
import com.example.letssopt.presentation.search.searchGraph
import com.example.letssopt.presentation.storage.storageGraph
import com.example.letssopt.presentation.user.login.loginGraph
import com.example.letssopt.presentation.user.signup.signupGraph
import com.example.letssopt.presentation.webtoon.webtoonGraph

@Composable
fun MainNavHost(
    appState: MainAppState,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = appState.navController,
        startDestination = Login,
        modifier = Modifier.padding(innerPadding)
    ) {
        loginGraph(
            LoginSuccess = {
                appState.navController.navigate(Home) {
                    popUpTo(Login) { inclusive = true }
                }

            },
            SignUpClick = {
                appState.navController.navigate(SignUp)
            }
        )
        signupGraph(
            onSignUpSuccess = {
                appState.navController.navigate(Login) {
                    popUpTo(SignUp) { inclusive = true }
                }
            }
        )
        homeGraph()
        purchaseGraph()
        searchGraph()
        storageGraph()
        webtoonGraph()
    }
}