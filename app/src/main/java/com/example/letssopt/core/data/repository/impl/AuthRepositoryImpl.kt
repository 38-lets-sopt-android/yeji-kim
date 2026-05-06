package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override suspend fun signUp(email: String, pw: String): Result<Unit> {
        return if (email == "yeji@test.com" && pw == "12345678") {
            Result.success(Unit)
        } else {
            Result.failure(Exception("회원가입 실패"))
        }
    }

    override suspend fun login(email: String, pw: String): Result<Unit> {
        return if (email == "yeji@test.com" && pw == "12345678") {
            Result.success(Unit)
        } else {
            Result.failure(Exception("로그인 실패"))
        }
    }

    override fun getLoggedIn(): Boolean = false
    override fun setLoggedIn(isLoggedIn: Boolean) {}
    override fun getEmail(): String? = null
    override fun getPassword(): String? = null
}
