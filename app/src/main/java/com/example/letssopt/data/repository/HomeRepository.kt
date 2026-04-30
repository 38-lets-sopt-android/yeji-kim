package com.example.letssopt.data.repository

import com.example.letssopt.data.HomeDataSet

interface HomeRepository {
    fun getHomeDataSet(): HomeDataSet
}