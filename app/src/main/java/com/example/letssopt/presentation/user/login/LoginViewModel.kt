package com.example.letssopt.presentation.user.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.letssopt.core.data.dto.SignInRequest
import com.example.letssopt.core.data.dto.client.RetrofitClient
import com.example.letssopt.core.data.repository.AuthRepository
import com.example.letssopt.core.data.repository.impl.AuthRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    data object Idle : LoginUiState()
    object Loading : LoginUiState()
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


    fun login(id: String, password: String) {
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading

            runCatching {
                RetrofitClient.authService.signIn(
                    SignInRequest(id, password)
                )
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    _uiState.value = LoginUiState.Success
                } else {
                    _uiState.value = LoginUiState.Error("아이디 또는 비밀번호가 올바르지 않습니다.")
                }
            }.onFailure {
                _uiState.value = LoginUiState.Error(it.message ?: "로그인 실패")
            }
        }
    }
}