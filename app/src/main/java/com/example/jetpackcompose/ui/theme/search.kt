package com.example.jetpackcompose.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun search(){
    val context = LocalContext.current.applicationContext
    Box(modifier = Modifier.fillMaxSize()) {

           ExtendedFloatingActionButton(onClick = {Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()}, modifier = Modifier.align(Alignment.BottomEnd).padding(20.dp)) {

               Icon(imageVector = Icons.Default.Menu, contentDescription = "add")
               Text(text = "Menu", fontSize = 16.sp)
           }

    }
}

@Preview
@Composable
fun searchPreview(){
    JetpackComposeTheme {
        search()
    }
}