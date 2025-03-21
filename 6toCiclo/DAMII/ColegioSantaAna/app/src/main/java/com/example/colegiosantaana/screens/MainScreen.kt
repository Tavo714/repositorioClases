package com.example.colegiosantaana.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.colegiosantaana.components.TopBar

@Composable
fun MainScreen(){
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.windowInsetsPadding(
                    WindowInsets.statusBars
                )
            ){
                TopBar(title = "Colegio Santa Ana")
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {innerPadding->
        Box(modifier = Modifier.padding(innerPadding)){
            //TODO:contenido de la pantalla principal
        }
    }
}
