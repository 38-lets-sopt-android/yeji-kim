package com.example.letssopt.core.data.service

import com.example.letssopt.core.data.dto.SignInRequest
import com.example.letssopt.core.data.dto.SignInResponse
import com.example.letssopt.core.data.dto.SignUpRequest
import com.example.letssopt.core.data.dto.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @POST("api/v1/auth/signin")
    suspend fun signIn(@Body request: SignInRequest): Response<SignInResponse>
}