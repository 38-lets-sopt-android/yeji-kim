package com.example.letssopt.presentation.user.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.letssopt.core.data.repository.impl.AuthRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Success : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel(
    private val AuthRepository: AuthRepositoryImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState = _uiState.asStateFlow()

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repositoryImpl = AuthRepositoryImpl()
                LoginViewModel(
                    AuthRepository = repositoryImpl
                )
            }
        }
    }

    fun login(mail: String, password: String, realMail: String, realPassword: String) {
        when {
            mail != realMail -> {
                _uiState.value = LoginUiState.Error("이메일이 일치하지 않습니다.")
            }

            password != realPassword -> {
                _uiState.value = LoginUiState.Error("비밀번호가 일치하지 않습니다.")
            }

            else -> {
                _uiState.value = LoginUiState.Success
            }
        }
    }
}