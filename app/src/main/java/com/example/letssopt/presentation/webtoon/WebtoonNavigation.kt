package com.example.letssopt.presentation.webtoon

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.MainTabRoute
import kotlinx.serialization.Serializable

@Serializable
data object Webtoon : MainTabRoute

fun NavGraphBuilder.webtoonGraph() {
    composable<Webtoon> {
        WebtoonScreen()
    }
}