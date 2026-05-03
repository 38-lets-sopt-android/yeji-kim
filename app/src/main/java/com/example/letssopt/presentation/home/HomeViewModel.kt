package com.example.letssopt.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.core.data.repository.HomeRepository
import com.example.letssopt.core.data.repository.impl.HomeRepositoryImpl

class HomeViewModel : ViewModel() {
    private val homeRepository: HomeRepository = HomeRepositoryImpl()

    var homeDataSet by mutableStateOf(homeRepository.getHomeDataSet())
        private set
}