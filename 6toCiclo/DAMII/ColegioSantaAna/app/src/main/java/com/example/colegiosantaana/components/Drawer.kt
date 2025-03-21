package com.example.colegiosantaana.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colegiosantaana.ui.theme.DarkGreen

@Composable
fun DrawerContent(
    onItemClicked: (String)-> Unit
){
    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        Text(text = "Menu", style = MaterialTheme.typography.headlineMedium, color = DarkGreen)
        Spacer(modifier = Modifier.height(16.dp))

        NavigationDrawerItem(
            label = { Text("Inicio")},
            selected = false,
            onClick = {onItemClicked("inicio")},
            icon = { Icon(Icons.Default.Home, contentDescription="Inicio")}
        )

        NavigationDrawerItem(
            label = { Text("Perfil")},
            selected = false,
            onClick = {onItemClicked("perfil")},
            icon = { Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar Sesion")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerPreview(){
    EcocityTheme{
        DrawerContent(onItemClicked = {})
    }
}