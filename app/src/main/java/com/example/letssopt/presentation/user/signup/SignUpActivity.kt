package com.example.letssopt.presentation.user.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.core.ui.theme.LETSSOPTTheme
import com.example.letssopt.core.ui.theme.SignUpTextField

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSignUpSuccess: () -> Unit,
    viewModel: SignUpViewModel = viewModel(
        factory = SignUpViewModel.Factory
    )
) {
    val pretendardBold = FontFamily(Font(R.font.pretendard_bold))
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var part by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()
    val isAllEntered =
        id.isNotEmpty() &&
                password.isNotEmpty() &&
                passwordConfirm.isNotEmpty() &&
                name.isNotEmpty() &&
                mail.isNotEmpty() &&
                age.isNotEmpty() &&
                part.isNotEmpty()

    LaunchedEffect(uiState) {
        if (uiState is SignUpUiState.Success) {
            onSignUpSuccess()
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
            .imePadding()
    ) {
        item {
            Text(
                text = "watcha",
                fontSize = 36.sp,
                color = Color(0xFFE8003C),
                fontWeight = FontWeight.Bold,
                fontFamily = pretendardBold,
                modifier = Modifier
                    .padding(top = 60.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
        item {
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "회원가입",
                fontSize = 20.sp,
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.Bold,
                fontFamily = pretendardBold,
            )
        }
        item {
            SignUpTextField(
                label = "아이디",
                value = id,
                placeholder = "아이디를 입력하세요",
                onValueChange = { id = it }
            )
        }
        item {
            SignUpTextField(
                label = "비밀번호",
                value = password,
                placeholder = "비밀번호를 입력하세요",
                onValueChange = { password = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
        }
        item {
            SignUpTextField(
                label = "비밀번호 확인",
                value = passwordConfirm,
                placeholder = "비밀번호를 다시 입력하세요",
                onValueChange = { passwordConfirm = it }
            )
        }
        item {
            SignUpTextField(
                label = "이름",
                value = name,
                placeholder = "이름을 입력하세요",
                onValueChange = { name = it }
            )
        }
        item {
            SignUpTextField(
                label = "이메일",
                value = mail,
                placeholder = "이메일을 입력하세요",
                onValueChange = { mail = it }
            )
        }
        item {
            SignUpTextField(
                label = "나이",
                value = age,
                placeholder = "나이를 입력하세요",
                onValueChange = { age = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        item {
            SignUpTextField(
                label = "파트",
                value = part,
                placeholder = "파트를 입력하세요",
                onValueChange = { part = it }
            )
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(48.dp))
                Button(
                    onClick = {
                        viewModel.signup(
                            id,
                            password,
                            passwordConfirm,
                            mail,
                            name,
                            age.toInt(),
                            part
                        )
                    },
                    enabled = isAllEntered,
                    modifier = Modifier
                        .padding(bottom = 26.dp)
                        .size(width = 320.dp, height = 52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE8003C),
                        disabledContainerColor = Color(0xFF555555),
                        contentColor = Color.White,
                        disabledContentColor = Color(0xFF999999)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("회원가입", fontFamily = pretendardBold)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(onSignUpSuccess = {})
    }
}
