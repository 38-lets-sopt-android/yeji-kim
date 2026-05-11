package com.example.letssopt.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.ui.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.component.HomeSectionList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsState()

    HomeSectionList(
        modifier = modifier,
        contentsTopSection = uiState.topSection,
        contentsMiddleSection = uiState.middleSection,
        contentsBottomSection = uiState.bottomSection
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme { }
}