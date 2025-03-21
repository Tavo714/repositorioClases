package com.example.clase09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clase09.ui.theme.Clase09Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun app() {
    LazyColumn(modifier = Modifier.fillMaxSize().background(Color.Green)){
        item {
        Image(
            modifier = Modifier.fillMaxWidth().height(500.dp),
            painter = painterResource(id = R.drawable.illidan_menos),
            contentDescription = "Illidan"
        )
        Text(text = "Lenguajes de Programacion 2025",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Text(text = "Java 2025",
            fontSize = 18.sp,
            color = Color.Blue)
        Text(text = "PHP 2025",
            fontSize = 18.sp,
            color = Color.Red)
        Text(text = "Kotlin 2025",
            fontSize = 18.sp,
            color = Color.Yellow)
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(20.dp)
            )

            {
                item {
                Text(text = "Informatica",
                    fontSize = 18.sp,
                    color = Color.Blue)
                Text(text = "Diseño Grafico",
                    fontSize = 18.sp,
                    color = Color.Blue)
                Text(text = "Administracion",
                    fontSize = 18.sp,
                    color = Color.Blue)
                Text(text = "Informatica",
                    fontSize = 18.sp,
                    color = Color.Blue)
                Text(text = "Diseño Grafico",
                    fontSize = 18.sp,
                    color = Color.Blue)
                Text(text = "Administracion",
                    fontSize = 18.sp,
                    color = Color.Blue)
            }
            }
        }
    }
}