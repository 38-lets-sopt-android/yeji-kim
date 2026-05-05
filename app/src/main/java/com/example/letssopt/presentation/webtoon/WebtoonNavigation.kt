package com.example.letssopt.presentation.webtoon

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Webtoon

fun NavGraphBuilder.webtoonGraph() {
    composable<Webtoon> {
        WebtoonScreen()
    }
}