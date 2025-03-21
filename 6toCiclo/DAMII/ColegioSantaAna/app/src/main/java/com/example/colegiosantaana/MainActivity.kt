package com.example.colegiosantaana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.colegiosantaana.screens.MainScreen
import com.example.colegiosantaana.ui.theme.ColegioSantaAnaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColegioSantaAnaTheme {
                MainScreen()
            }
        }
    }
}
