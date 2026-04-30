package com.example.letssopt.data.repository.impl

import com.example.letssopt.data.repository.StorageRepository

class StorageRepositoryImpl : StorageRepository {
    override fun getStorageTitle(): String {
        return "보관함 화면"
    }
}