package com.example.letssopt.navigation

import kotlinx.serialization.Serializable

@Serializable
data object Login : MainTabRoute

@Serializable
data object SignUp : MainTabRoute

@Serializable
data object Home : MainTabRoute

@Serializable
data object Purchase : MainTabRoute

@Serializable
data object Search : MainTabRoute

@Serializable
data object Storage : MainTabRoute

@Serializable
data object Webtoon : MainTabRoute

interface Route