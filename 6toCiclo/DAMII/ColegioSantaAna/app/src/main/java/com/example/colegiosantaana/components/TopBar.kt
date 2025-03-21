package com.example.colegiosantaana.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.colegiosantaana.ui.theme.ColegioSantaAnaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String){
    TopAppBar(
        title={
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(text = title, color= MaterialTheme.colorScheme.onPrimary)
            }
        },
        navigationIcon={
            IconButton(onClick = {/*TODO: PROGRAMAR LOS BOTONES*/}) {
                Icon(
                    imageVector= Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        actions={
            IconButton(onClick = {/*TODO PROGRAMAR ACCIONES*/}) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notificaciones",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview
@Composable
fun PreviewTopBar(){
    ColegioSantaAnaTheme {
        TopBar(title = "Santa Ana")
    }
}