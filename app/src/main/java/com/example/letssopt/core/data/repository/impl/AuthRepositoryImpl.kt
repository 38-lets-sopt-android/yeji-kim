package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.LoginDataSet

interface AuthRepository {
    fun getAuthDataSet(): List<LoginDataSet> {
        return listOf(
            LoginDataSet()
        )
    }
}

class AuthRepositoryImpl : AuthRepository {
    fun login(id: String, pw: String): Result<Unit> {
        return try {
            val result = login(id, pw)

            return if (id == "yeji" && pw == "1234") {
                Result.success(Unit)
            } else {
                Result.failure(result.exceptionOrNull() ?: Exception("로그인 실패"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun signup(id: String, pw: String): Result<Unit> {
        return try {
            val result = signup(id, pw)

            return if (id == "yeji" && pw == "1234") {
                Result.success(Unit)
            } else {
                Result.failure(result.exceptionOrNull() ?: Exception("로그인 실패"))
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}