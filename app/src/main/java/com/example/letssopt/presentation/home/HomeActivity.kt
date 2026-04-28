package com.example.letssopt.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.component.BottomNavigation
import com.example.letssopt.component.TopAppBar
import com.example.letssopt.presentation.purchase.PurchaseScreen
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.storage.StorageScreen
import com.example.letssopt.presentation.webtoon.WebtoonScreen
import com.example.letssopt.ui.theme.LETSSOPTTheme

class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}


@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        bottomBar = {
            BottomNavigation(
                selectedTabIndex = selectedTab,
                onTabSelected = { index -> selectedTab = index }
            )
        },
        topBar = {
            TopAppBar()
        }
    ) { innerPadding ->
        val homeData = viewModel.getHomeDataSet()

        when (selectedTab) {
            0 -> LazyList(
                contentsMiddleSection = homeData.middleSection,
                contentsBottomSection = homeData.bottomSection,
                contentsTopSection = homeData.topSection,
                modifier = Modifier.padding(innerPadding)
            )

            1 -> PurchaseScreen()

            2 -> WebtoonScreen()

            3 -> SearchScreen()

            4 -> StorageScreen()

            else -> LazyList(
                contentsMiddleSection = homeData.middleSection,
                contentsBottomSection = homeData.bottomSection,
                contentsTopSection = homeData.topSection,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        HomeScreen(viewModel = viewModel())
    }
}