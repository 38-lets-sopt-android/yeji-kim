package com.example.letssopt.core.data

data class Content(
    val title: String,
    val imageRes: Int
)

data class HomeDataSet(
    val topSection: List<Content>,
    val middleSection: List<Content>,
    val bottomSection: List<Content>
)

data class LoginDataSet(
    val mail: String = "",
    val password: String = "",
    val realMail: String = "",
    val realPassword: String = ""
)