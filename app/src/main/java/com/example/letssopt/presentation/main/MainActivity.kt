package com.example.letssopt.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.letssopt.core.ui.theme.LETSSOPTTheme
import com.example.letssopt.presentation.main.component.rememberMainAppState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                val appState = rememberMainAppState()
                MainScreen(appState = appState)
            }
        }
    }
}