package com.example.letssopt.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.ui.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.component.HomeSectionList
import com.example.letssopt.presentation.main.MainScreen
import com.example.letssopt.presentation.main.component.rememberMainAppState

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                val appState = rememberMainAppState()
                MainScreen(appState = appState)
            }
        }
    }
}
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HomeTopSection(modifier = modifier)
    HomeMiddleSection(modifier = modifier)
    HomeBottomSection(modifier = modifier)
}

@Composable
fun HomeTopSection(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeSectionList(
        contentsTopSection = uiState.topSection,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
    )
}

@Composable
fun HomeMiddleSection(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeSectionList(
        contentsMiddleSection = uiState.middleSection,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
    )
}

@Composable
fun HomeBottomSection(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeSectionList(
        contentsBottomSection = uiState.bottomSection,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme { }
}