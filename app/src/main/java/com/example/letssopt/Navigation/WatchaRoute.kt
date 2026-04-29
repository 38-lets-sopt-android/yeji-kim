package com.example.letssopt.component

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
    data class Detail(val id: Int) : Route
}