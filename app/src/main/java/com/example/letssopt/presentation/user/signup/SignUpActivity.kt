package com.example.letssopt.presentation.user.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.R
import com.example.letssopt.core.ui.theme.LETSSOPTTheme

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onSignUpSuccess: () -> Unit,
    viewModel: SignUpViewModel = viewModel(
        factory = SignUpViewModel.Factory
    )
) {
    val pretendardBold = FontFamily(Font(R.font.pretendard_bold))
    val pretendardRegular = FontFamily(Font(R.font.pretendard_regular))
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.Black)
            .padding(horizontal = 20.dp)
            .imePadding()
    ) {
        Text(
            text = "watcha",
            fontSize = 36.sp,
            color = Color(0xFFE8003C),
            fontWeight = FontWeight.Bold,
            fontFamily = pretendardBold,
            modifier = Modifier
                .padding(top = 60.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "회원가입",
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold,
            fontFamily = pretendardBold,
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(text = "아이디", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = id,
            onValueChange = { id = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (id.isEmpty()) {
                        Text(
                            "아이디를 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "비밀번호", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (password.isEmpty()) {
                        Text(
                            "비밀번호를 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "비밀번호 확인", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (passwordConfirm.isEmpty()) {
                        Text(
                            "비밀번호를 다시 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "이름", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (name.isEmpty()) {
                        Text(
                            "이름을 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "이메일", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = mail,
            onValueChange = { mail = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (mail.isEmpty()) {
                        Text(
                            "이메일을 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "나이", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = age,
            onValueChange = { age = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (age.isEmpty()) {
                        Text(
                            "나이를 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "파트", color = Color(0xFF999999), fontFamily = pretendardRegular)
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = part,
            onValueChange = { part = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFF2A2A2A), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (part.isEmpty()) {
                        Text(
                            "파트를 입력하세요",
                            color = Color(0xFF666666),
                            fontFamily = pretendardRegular
                        )
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                viewModel.signup(id, password, passwordConfirm, mail, name, age.toInt(), part)
            },
            enabled = isAllEntered,
            modifier = Modifier
                .padding(bottom = 26.dp)
                .align(Alignment.CenterHorizontally)
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

@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(onSignUpSuccess = {})
    }
}