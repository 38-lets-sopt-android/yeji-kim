package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.letssopt.core.data.Content
import com.example.letssopt.core.data.repository.HomeRepository
import com.example.letssopt.core.data.repository.impl.HomeRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val topSection : List<Content> = emptyList(),
    val middleSection: List<Content> = emptyList(),
    val bottomSection: List<Content> = emptyList()
)

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repositoryImpl = HomeRepositoryImpl()
                HomeViewModel(
                    homeRepository = repositoryImpl
                )
            }
        }
    }
}