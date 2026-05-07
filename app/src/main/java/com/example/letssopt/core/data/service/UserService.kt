package com.example.letssopt.core.data.service

import com.example.letssopt.core.data.dto.GetUserProfile
import com.example.letssopt.core.data.model.UserList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Query

interface UserService {
    @GET("api/v1/users")
    suspend fun getUserProfile(
        @Query("Id") userId: String
    ): Response<GetUserProfile>

    @PATCH("api/v1/users")
    suspend fun updateUserProfile(
        @Query("Id") userId: String
    ): Response<GetUserProfile>

    @GET("api/v1/users")
    suspend fun getUserList(
    ): UserList
}