package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android", "Google")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, author: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(all = 10.dp)
            .background(color = Color.Green)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = name,
            color = Color.White,
            fontSize = 50.sp,
        )
        Text(text = "by", fontSize = 20.sp)
        Text(
            text = author, fontSize = 25.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(color = Color.Black)
        ) {

            Text(
                text = "Anima",
                fontSize = 35.sp,
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
        Row(Modifier.padding(top = 30.dp)) {
            Image(
                imageVector = Icons.Default.ArrowBack,
                colorFilter = ColorFilter.tint(color = Color.White),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Image(
                imageVector = Icons.Default.Add,
                colorFilter = ColorFilter.tint(color = Color.White),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Image(
                imageVector = Icons.Default.ArrowForward,
                colorFilter = ColorFilter.tint(color = Color.White),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Column() {
            Greeting("Android", "Google")
        }

    }
}