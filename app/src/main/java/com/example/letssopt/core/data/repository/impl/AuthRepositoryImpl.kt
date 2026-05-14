package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.UserPreferenceManager
import com.example.letssopt.core.data.dto.SignInRequest
import com.example.letssopt.core.data.dto.SignUpRequest
import com.example.letssopt.core.data.dto.client.RetrofitClient
import com.example.letssopt.core.data.repository.AuthRepository
import com.example.letssopt.core.data.service.AuthService

class AuthRepositoryImpl(
    private val autjService: AuthService = RetrofitClient.authService,
    private val userPreferenceManager: UserPreferenceManager
) : AuthRepository {

    override suspend fun login(id: String, pw: String): Result<Unit> {
        return runCatching {
            val response = autjService.signIn(SignInRequest(id, pw))
            if (response.isSuccessful) {
                userPreferenceManager.saveUserLoginState(true)
            } else {
                throw Exception("아이디 또는 비밀번호가 틀렸습니다.")
            }
        }
    }


    override suspend fun signUp(
        id: String,
        pw: String,
        mail: String,
        name: String,
        age: Int,
        part: String
    ): Result<Unit> {
        return runCatching {
            val response = autjService.signUp(
                SignUpRequest(
                    loginId = id,
                    password = pw,
                    passwordConfirm = pw,
                    name = name,
                    email = mail,
                    age = age,
                    part = part
                )
            )
            if (response.isSuccessful) {
                Unit
            } else {
                throw Exception(response.message() ?: "회원가입에 실패했습니다.")
            }
        }
    }

    override fun getLoggedIn(): Boolean = false
    override fun setLoggedIn(isLoggedIn: Boolean) {}
    override fun getId(): String? = null
    override fun getPassword(): String? = null
}