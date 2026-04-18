package com.example.letssopt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.R
import com.example.letssopt.component.BottomNavigation
import com.example.letssopt.component.LazyList
import com.example.letssopt.component.TopNavigation
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        bottomBar = {
            BottomNavigation(
                selectedTabIndex = selectedTab,
                onTabSelected = { index -> selectedTab = index }
            )
        },
        topBar = {
            TopNavigation()
        }
    ) { innerPadding ->
        when (selectedTab) {
            0 -> LazyList(modifier = Modifier.padding(innerPadding))
            1 -> Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    "개별구매 화면",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            2 -> Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    "웹툰 화면",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            3 -> Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    "찾기 화면",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            4 -> Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Text(
                    "보관함 화면",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> LazyList(modifier = Modifier.padding(innerPadding))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LETSSOPTTheme {
        MainScreen()
    }
}