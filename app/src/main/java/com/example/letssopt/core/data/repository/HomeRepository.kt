package com.example.letssopt.core.data.repository

import com.example.letssopt.core.data.Content
import com.example.letssopt.core.data.HomeDataSet

interface HomeRepository {
    fun getHomeDataSet(): HomeDataSet
    suspend fun getTopImages(): List<Content>
    suspend fun getMiddleImages(): List<Content>
    suspend fun getBottomImages(): List<Content>
}