package com.example.letssopt.presentation.webtoon

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.letssopt.navigation.Webtoon

fun NavController.navigateToWebtoon(navOptions: NavOptions) = navigate(Webtoon, navOptions)
fun NavGraphBuilder.webtoonGraph() {
    composable<Webtoon> {
        WebtoonScreen()
    }
}