package com.example.letssopt.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserList(
@SerialName("success")
val success: Boolean,
@SerialName("status")
val status: Int,
@SerialName("message")
val message: String,
@SerialName("code")
val code: String,
@SerialName("data")
val data: UserData ?= null
)

@Serializable
data class UserData(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("part")
    val part: String,
    @SerialName("users")
    val users: List<User>
)

@Serializable
data class User(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("part")
    val part: String
)