package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.LoginDataSet

interface AuthRepository {
    fun getAuthDataSet(): List<LoginDataSet>
}