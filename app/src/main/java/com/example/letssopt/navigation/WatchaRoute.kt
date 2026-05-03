package com.example.letssopt.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Search : Route

    @Serializable
    data object Purchase : Route

    @Serializable
    data object Storage : Route

    @Serializable
    data object Webtoon : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object SignUp : Route
}