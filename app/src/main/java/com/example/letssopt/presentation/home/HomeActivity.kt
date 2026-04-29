package com.example.letssopt.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.component.BottomNavigation
import com.example.letssopt.navigation.Route
import com.example.letssopt.navigation.WatchaNavigation
import com.example.letssopt.ui.theme.LETSSOPTTheme

class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    bottomBar = {
                        // 3. 우리가 만든 바텀바 부품 끼우기!
                        BottomNavigation(
                            selectedTabIndex = when {
                                currentDestination?.hasRoute<Route.Home>() == true -> 0
                                currentDestination?.hasRoute<Route.Purchase>() == true -> 1
                                currentDestination?.hasRoute<Route.Webtoon>() == true -> 2
                                currentDestination?.hasRoute<Route.Search>() == true -> 3
                                currentDestination?.hasRoute<Route.Storage>() == true -> 4
                                else -> 0
                            },
                            onTabSelected = { index ->
                                // 클릭 시 해당 Route 객체로 이동!
                                val targetRoute = when (index) {
                                    0 -> Route.Home
                                    1 -> Route.Purchase
                                    2 -> Route.Webtoon
                                    3 -> Route.Search
                                    4 -> Route.Storage
                                    else -> Route.Home
                                }

                                navController.navigate(targetRoute) {
                                    // 탭 전환 시 스택이 쌓이지 않게 하는 옵션 (중요!)
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    // 4. 우리가 만든 지도 부품 펼치기!
                    WatchaNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel, modifier: Modifier = Modifier) {
    val homeData = viewModel.getHomeDataSet()
    LazyList(
        contentsMiddleSection = homeData.middleSection,
        contentsBottomSection = homeData.bottomSection,
        contentsTopSection = homeData.topSection,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        HomeScreen(viewModel = viewModel())
    }
}