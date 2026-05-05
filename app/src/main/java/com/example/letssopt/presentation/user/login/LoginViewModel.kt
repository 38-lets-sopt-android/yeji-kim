package com.example.letssopt.presentation.user.login

import androidx.lifecycle.ViewModel
import com.example.letssopt.core.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class LoginUiState {
    data object Idle : LoginUiState()
    data object Success : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel(
    private val AuthRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState = _uiState.asStateFlow()

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