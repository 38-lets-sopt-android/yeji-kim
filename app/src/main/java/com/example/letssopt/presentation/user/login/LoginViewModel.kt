package com.example.letssopt.presentation.user.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.letssopt.core.data.repository.AuthRepository
import com.example.letssopt.core.data.repository.impl.AuthRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Success : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState = _uiState.asStateFlow()

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginViewModel(
                    authRepository = AuthRepositoryImpl()
                )
            }
        }
    }


    fun login(mail: String, password: String) {
        viewModelScope.launch {
            val result = authRepository.login(mail, password)
            result.fold(
                onSuccess = { _uiState.value = LoginUiState.Success },
                onFailure = { _uiState.value = LoginUiState.Error(it.message ?: "로그인 실패") }
            )
        }
    }
}