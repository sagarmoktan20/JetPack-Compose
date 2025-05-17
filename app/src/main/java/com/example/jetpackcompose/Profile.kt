package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.greenJc

@Composable
fun Profile(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize().align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(text = "Profile Screen", fontSize = 20.sp, color = greenJc)

        }
    }
}

@Preview
@Composable
fun ProfilePreview(){
    JetpackComposeTheme {
        Profile()
    }
}