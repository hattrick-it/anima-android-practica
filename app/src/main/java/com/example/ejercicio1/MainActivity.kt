package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio1.ui.theme.Ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ejemploEstado()
                }
            }
        }
    }
}

@Composable
fun columnaPrincipal() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = "fondo de pantalla"
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(horizontal = 16.dp), textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            Modifier.padding(16.dp), textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun taskManager() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_task_completed),
                contentDescription = "task completed"
            )
            Text(
                text = "All tasks completed",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(text = "Nice work!", fontSize = 16.sp)
        }
    }
}

@Composable
fun ejercicioCuadrantes() {
    Column(Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Card(
                title = "Text composable",
                text = "Displays text and follows Material Design guidelines.",
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.Green)
            )
            Card(
                title = "Image composable",
                text = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.Yellow)
            )
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Card(
                title = "Row composable",
                text = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.Cyan)
            )
            Card(
                title = "Column composable",
                text = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .weight(1f)
                    .background(color = Color.LightGray)
            )
        }


    }
}

@Composable
fun Card(title: String, text: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp), textAlign = TextAlign.Justify
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Contador() {
    var numero by remember { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "número = $numero", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Button(onClick = {
                numero -= 1
            }) {
                Text(text = "-", fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(onClick = {
                numero += 1
            }) {
                Text(text = "+", fontSize = 30.sp)
            }
        }
    }
}

@Composable
fun ejemploEstado() {
    var input by remember {
        mutableStateOf("")
    }
    var text by remember {
        mutableStateOf("valor inicial")
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row() {
            OutlinedTextField(modifier = Modifier.weight(1f), value = input,
                onValueChange = { nuevoValor:String ->
                    input = nuevoValor
            })
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                text = input
            }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("cambiar", textAlign = TextAlign.Center)
                    Text("texto", textAlign = TextAlign.Center)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = text, fontSize = 30.sp)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ejercicio1Theme {
        ejemploEstado()
    }
}

