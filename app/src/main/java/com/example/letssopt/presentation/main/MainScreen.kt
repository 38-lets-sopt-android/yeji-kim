package com.example.letssopt.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.letssopt.navigation.MainNavHost
import com.example.letssopt.presentation.home.component.BottomNavigation
import com.example.letssopt.presentation.main.component.MainAppState
import com.example.letssopt.presentation.main.component.MainTab

@Composable
fun MainScreen(
    appState: MainAppState
) {
    val showBottomBar by appState.showBottomBar.collectAsStateWithLifecycle()
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF141414),
        bottomBar = {
            BottomNavigation(
                isshowBottomBar = showBottomBar,
                tabs = MainTab.entries.toList(),
                currentTab = currentTab ?: MainTab.HOME,
                selectedTabIndex = MainTab.entries.indexOf(currentTab),
                onTabSelected = { index ->
                    val selectedTab = MainTab.entries[index]
                    appState.navigate(selectedTab) }
            )
        }
    ) { innerPadding ->
        MainNavHost(
            appState = appState,
            innerPadding = innerPadding
        )
    }
}