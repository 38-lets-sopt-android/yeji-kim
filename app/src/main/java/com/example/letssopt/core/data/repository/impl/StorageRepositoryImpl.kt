package com.example.letssopt.core.data.repository.impl

import com.example.letssopt.core.data.repository.StorageRepository

class StorageRepositoryImpl : StorageRepository {
    override fun getStorageTitle(): String {
        return "보관함 화면"
    }
}