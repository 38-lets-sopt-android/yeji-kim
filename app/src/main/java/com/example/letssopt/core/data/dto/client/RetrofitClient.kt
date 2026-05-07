package com.example.letssopt.core.data.dto.client

import com.example.letssopt.BuildConfig
import com.example.letssopt.core.data.service.ApiService
import com.example.letssopt.core.data.service.UserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitClient {
    private const val BASE_URL = BuildConfig.BASE_URL

    private val json = Json { ignoreUnknownKeys = true }


    private val okHttpClient = OkHttpClient.Builder()
        .build()

    private val instance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val apiService: ApiService = instance.create(ApiService::class.java)
    val userService: UserService = instance.create(UserService::class.java)
}