package com.example.letssopt.ui.theme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Color as AndroidColor

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(
                AndroidColor.WHITE, AndroidColor.WHITE
            )
        )
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

private fun validateSignUp(mail: String, password: String, passwordConfirm: String): String? {
    if (!EMAIL_ADDRESS.matcher(mail).matches()) {
        return "이메일 형식이 올바르지 않습니다."
    }
    if (password.length !in 8..12) {
        return "비밀번호는 8~12자 이내로 입력해주세요."
    }
    if (password != passwordConfirm) {
        return "비밀번호가 일치하지 않습니다."
    }
    return null
}

@Composable
fun SignUpScreen(name: String, modifier: Modifier = Modifier) {
    var mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    val context = LocalContext.current
    val isAllEntered = mail.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "watcha",
            fontSize = 36.sp,
            color = Color(0xFFE8003C),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 60.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "회원가입",
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(text = "이메일", color = Color(0xFF999999))
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
                        Text("이메일 주소를 입력하세요", color = Color(0xFF666666))
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "비밀번호", color = Color(0xFF999999))
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
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
                        Text("비밀번호를 입력하세요", color = Color(0xFF666666))
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = "비밀번호 확인", color = Color(0xFF999999))
        Spacer(modifier = Modifier.height(3.dp))
        BasicTextField(
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
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
                        Text("비밀번호를 다시 입력하세요", color = Color(0xFF666666))
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                val errorMessage = validateSignUp(mail, password, passwordConfirm)

                if (errorMessage == null) {
                    Toast.makeText(context, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent().apply {
                        putExtra("mail", mail)
                        putExtra("password", password)
                    }
                    val activity = context as? Activity
                    activity?.setResult(Activity.RESULT_OK, intent)
                    activity?.finish()
                } else {
                    Toast.makeText(context, "이메일 혹인 비밀번호 형식이 맞지 않습니다.", Toast.LENGTH_SHORT).show()
                }
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
            Text("회원가입")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    LETSSOPTTheme {
        SignUpScreen("Android")
    }
}