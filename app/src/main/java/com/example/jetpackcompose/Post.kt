package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.greenJc

@Composable
fun Post(){
    val postsList = listOf("post1","post2","post3","post4","post5","post6","post7","post8","post9","post10","post11","post12","post13","post14","post15","post16","post17","post18","post19","post20","post21","post22","post23","post24","post25")
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
           // Text(text = "Post Screen", fontSize = 30.sp, color = greenJc)
//            LazyColumn {
//                items(postsList){
//                    Text(text = it, fontSize = 30.sp, color = greenJc)
//                }
//            }
            LazyRow {
                items(postsList){
                    Text(text = it, fontSize = 30.sp, color = greenJc)
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    JetpackComposeTheme {
        Post()
    }
}