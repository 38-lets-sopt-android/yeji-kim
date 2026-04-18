package com.example.letssopt.ui.theme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Color as AndroidColor


class LoginActivity : ComponentActivity() {
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
                    LoginScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {
    var mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var realMail by remember { mutableStateOf("") }
    var realPassword by remember { mutableStateOf("") }
    val context = LocalContext.current
    val signUpLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            realMail = result.data?.getStringExtra("mail") ?: ""
            realPassword = result.data?.getStringExtra("password") ?: ""
            mail = realMail
            password = realPassword
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF141414))
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
            text = "이메일로 로그인",
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
                        Text("이메일을 입력하세요", color = Color(0xFF666666))
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
                        Text("비밀번호를 입력하세요", color = Color(0xFF666666))
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "아직 계정이 없으신가요? 회원가입", fontSize = 14.sp, color = Color(0xFF999999),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable(onClick = {
                    val intent = Intent(context, SignUpActivity::class.java)
                    signUpLauncher.launch(intent)
                })
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (mail == realMail && password == realPassword) {
                    val intent = Intent(context, MainActivity::class.java).apply {
                        putExtra("mail", mail)
                        putExtra("password", password)
                    }
                    Toast.makeText(context, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    context.startActivity(intent)
                    (context as? Activity)?.finish()
                } else {
                    Toast.makeText(context, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(bottom = 26.dp)
                .align(Alignment.CenterHorizontally)
                .size(width = 320.dp, height = 52.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE8003C)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("로그인", color = Color.White)
        }
    }
}

@Composable
fun BasicField(
    value: String,
    onValueChange: () -> Unit,
    placeholder: () -> Unit,
    visualTransformation: PasswordVisualTransformation,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LETSSOPTTheme { }
}