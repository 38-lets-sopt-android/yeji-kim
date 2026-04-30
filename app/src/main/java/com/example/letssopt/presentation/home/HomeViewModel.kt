package com.example.letssopt.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.data.HomeDataSet
import com.example.letssopt.data.repository.HomeRepository
import com.example.letssopt.data.repository.HomeRepositoryImpl

class HomeViewModel : ViewModel() {
    private val homeRepository: HomeRepository = HomeRepositoryImpl()

    var homeDataSet by mutableStateOf(homeRepository.getHomeDataSet())
        private set

    fun updateHomeDataSet(newData: HomeDataSet) {
        homeDataSet = newData
    }
}