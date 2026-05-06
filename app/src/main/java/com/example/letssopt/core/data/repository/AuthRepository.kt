package com.example.letssopt.core.data.repository

interface AuthRepository {
    suspend fun signUp(email: String, pw: String): Result<Unit>
    suspend fun login(email: String, pw: String): Result<Unit>
    fun getLoggedIn(): Boolean
    fun setLoggedIn(isLoggedIn: Boolean)
    fun getEmail(): String?
    fun getPassword(): String?
}