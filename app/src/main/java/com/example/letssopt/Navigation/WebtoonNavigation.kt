package com.example.letssopt.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.letssopt.presentation.webtoon.WebtoonScreen

fun NavGraphBuilder.webtoonGraph(
    innerPadding: PaddingValues,
) {
    composable<Route.Webtoon> {
        WebtoonScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}