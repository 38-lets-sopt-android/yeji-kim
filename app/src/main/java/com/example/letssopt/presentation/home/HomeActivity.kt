package com.example.letssopt.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import com.example.letssopt.navigation.Route
import com.example.letssopt.navigation.homeGraph
import com.example.letssopt.navigation.loginGraph
import com.example.letssopt.navigation.purchaseGraph
import com.example.letssopt.navigation.rememberMainNavigator
import com.example.letssopt.navigation.searchGraph
import com.example.letssopt.navigation.signupGraph
import com.example.letssopt.navigation.storageGraph
import com.example.letssopt.navigation.webtoonGraph
import com.example.letssopt.presentation.home.component.BottomNavigation
import com.example.letssopt.presentation.home.component.TopAppBar
import com.example.letssopt.core.ui.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.component.LazyList

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                val navigator = rememberMainNavigator()

                Scaffold(
                    topBar = { TopAppBar() },
                    bottomBar = {
                        BottomNavigation(
                            selectedTabIndex = navigator.currentTab,
                            onTabSelected = { index -> navigator.navigateTo(index) }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navigator.navController,
                        startDestination = Route.Home
                    ) {
                        homeGraph(innerPadding = innerPadding)
                        purchaseGraph(innerPadding = innerPadding)
                        searchGraph(innerPadding = innerPadding)
                        storageGraph(innerPadding = innerPadding)
                        webtoonGraph(innerPadding = innerPadding)
                        loginGraph(innerPadding = innerPadding)
                        signupGraph(innerPadding = innerPadding)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel, modifier: Modifier = Modifier) {
    val data = viewModel.homeDataSet

    LazyList(
        contentsMiddleSection = data.middleSection,
        contentsBottomSection = data.bottomSection,
        contentsTopSection = data.topSection,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
    )

}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        Scaffold(
            topBar = { TopAppBar() },
            bottomBar = {
                BottomNavigation(
                    selectedTabIndex = 0,
                    onTabSelected = {}
                )
            }
        ) { innerPadding ->
            HomeScreen(
                viewModel = viewModel(),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}