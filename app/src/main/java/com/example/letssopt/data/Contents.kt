package com.example.letssopt.data

data class Content(
    val title: String,
    val imageRes: Int
)

data class HomeDataSet(
    val topSection: List<Content>,
    val middleSection: List<Content>,
    val bottomSection: List<Content>
)