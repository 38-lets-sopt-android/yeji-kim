package com.example.letssopt.presentation.storage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.data.repository.StorageRepository
import com.example.letssopt.data.repository.impl.StorageRepositoryImpl

class StorageViewModel : ViewModel() {
    private val storageRepository: StorageRepository = StorageRepositoryImpl()

    var storageTitle by mutableStateOf(storageRepository.getStorageTitle())
        private set
}