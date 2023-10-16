package com.example.ejercicio1ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val contesto : Context = this
            AppUI(contesto)
        }
    }
}

@Composable
fun AppUI(contesto : Context) {
    var count by remember { mutableIntStateOf(0) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Yellow),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                coroutineScope.launch {
                    // Incrementa el contador cuando se hace clic en el botón "Contar"
                    count++
                }
            },
            modifier = Modifier
                .fillMaxWidth().height(60.dp),
            shape = RectangleShape
        ) {
            Text(text = "Contar")
        }

        Text(
            text = count.toString(),
            fontSize = 80.sp,
            color = Color.Magenta,
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                val message = "El número actual de pulsaciones es $count"

                Toast.makeText(contesto, message, Toast.LENGTH_SHORT).show()

            },
            modifier = Modifier
                .fillMaxWidth().height(60.dp),
            shape = RectangleShape
        ) {
            Text(text = "Toast")
        }
    }
}