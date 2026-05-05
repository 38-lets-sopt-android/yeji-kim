package com.example.letssopt.core.data.repository

import com.example.letssopt.core.data.LoginDataSet

interface AuthRepository {
    fun getAuthDataSet(): List<LoginDataSet>
}