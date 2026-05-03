package com.example.letssopt.core.data.repository

import com.example.letssopt.core.data.HomeDataSet

interface HomeRepository {
    fun getHomeDataSet(): HomeDataSet
}