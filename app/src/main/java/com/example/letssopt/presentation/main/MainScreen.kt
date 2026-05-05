package com.example.letssopt.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.example.letssopt.navigation.Login
import com.example.letssopt.presentation.home.component.BottomNavigation
import com.example.letssopt.presentation.home.navigation.homeGraph
import com.example.letssopt.presentation.main.component.MainAppState
import com.example.letssopt.presentation.main.component.MainTab
import com.example.letssopt.presentation.purchase.purchaseGraph
import com.example.letssopt.presentation.search.searchGraph
import com.example.letssopt.presentation.storage.storageGraph
import com.example.letssopt.presentation.webtoon.webtoonGraph

@Composable
fun MainScreen(
    appState: MainAppState
) {
    val showBottomBar by appState.showBottomBar.collectAsStateWithLifecycle()
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigation(
                isshowBottomBar = showBottomBar,
                currentTab = currentTab ?: MainTab.HOME,
                selectedTabIndex = MainTab.entries.indexOf(currentTab),
                onTabSelected = { index ->
                    val targetTab = MainTab.entries[index]
                    appState.navController.navigate(targetTab.route)
                }
            )
        }
    ) { innerPadding ->
        MainNavHost(
            appState = appState,
            innerPadding = innerPadding
        )
    }
}

@Composable
private fun MainNavHost(
    appState: MainAppState,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = appState.navController,
        startDestination = Login,
        modifier = Modifier.padding(innerPadding)
    ) {
        homeGraph()
        purchaseGraph()
        searchGraph()
        storageGraph()
        webtoonGraph()
    }
}