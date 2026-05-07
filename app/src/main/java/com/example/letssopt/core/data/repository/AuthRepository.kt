package com.example.letssopt.core.data.repository

interface AuthRepository {
    suspend fun signUp(id: String, pw: String, mail: String, name: String, age: Int, part: String): Result<Unit>
    suspend fun login(id: String, pw: String): Result<Unit>
    fun getLoggedIn(): Boolean
    fun setLoggedIn(isLoggedIn: Boolean)
    fun getId(): String?
    fun getPassword(): String?
}