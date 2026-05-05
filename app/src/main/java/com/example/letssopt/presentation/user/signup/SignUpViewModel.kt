package com.example.letssopt.presentation.user.signup

import android.content.Intent
import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import com.example.letssopt.core.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class SignUpUiState {
    data object Idle : SignUpUiState()
    data object Success : SignUpUiState()
    data class Error(val message: String) : SignUpUiState()
}

class SignUpViewModel (
    private val AuthRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Idle)
    val uiState = _uiState.asStateFlow()
    fun signup(mail: String, password: String, passwordConfirm: String) {
        when {
            !EMAIL_ADDRESS.matcher(mail).matches() -> {
                _uiState.value = SignUpUiState.Error("이메일 형식이 맞지 않습니다.")
            }

            password.length !in 8..12 -> {
                _uiState.value = SignUpUiState.Error("비밀번호는 8자 이상 12자 이하로 입력하세요.")
            }

            password != passwordConfirm -> {
                _uiState.value = SignUpUiState.Error("비밀번호가 일치하지 않습니다.")
            }

            else -> {
                _uiState.value = SignUpUiState.Success
                val intent = Intent().apply {
                    putExtra("mail", mail)
                    putExtra("password", password)
                }
            }
        }

    }
}