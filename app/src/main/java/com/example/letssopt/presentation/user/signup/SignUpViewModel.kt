package com.example.letssopt.presentation.user.signup

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.letssopt.core.data.repository.AuthRepository
import com.example.letssopt.core.data.repository.impl.AuthRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

sealed class SignUpUiState {
    data object Idle : SignUpUiState()
    data object Success : SignUpUiState()
    data class Error(val message: String) : SignUpUiState()
}

class SignUpViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<SignUpUiState>(SignUpUiState.Idle)

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repositoryImpl = AuthRepositoryImpl()
                SignUpViewModel(authRepository = repositoryImpl)
            }
        }
    }

    fun signup(mail: String, password: String, passwordConfirm: String) {
        when {
            !EMAIL_ADDRESS.matcher(mail).matches() ->
                _uiState.value = SignUpUiState.Error("이메일 형식이 맞지 않습니다.")

            password.length !in 8..12 ->
                _uiState.value = SignUpUiState.Error("비밀번호는 8자 이상 12자 이하로 입력하세요.")

            password != passwordConfirm ->
                _uiState.value = SignUpUiState.Error("비밀번호가 일치하지 않습니다.")

            else -> {
                viewModelScope.launch {
                    val result = authRepository.signUp(mail, password)
                    result.fold(
                        onSuccess = { _uiState.value = SignUpUiState.Success },
                        onFailure = {
                            _uiState.value = SignUpUiState.Error(it.message ?: "회원가입 실패")
                        }
                    )
                }
            }
        }
    }
}