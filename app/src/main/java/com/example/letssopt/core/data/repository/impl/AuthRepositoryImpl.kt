package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {

    override suspend fun login(id: String, pw: String): Result<Unit> {
        return if (id.isNotEmpty() && pw.isNotEmpty()) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("로그인 실패"))
        }
    }

    override suspend fun signUp(email: String, pw: String): Result<Unit> {
        return if (email.isNotEmpty() && pw.isNotEmpty()) {
            Result.success(Unit)
        } else {
            Result.failure(Exception("회원가입 실패"))
        }
    }

    override fun getLoggedIn(): Boolean = false
    override fun setLoggedIn(isLoggedIn: Boolean) {}
    override fun getId(): String? = null
    override fun getPassword(): String? = null
}
