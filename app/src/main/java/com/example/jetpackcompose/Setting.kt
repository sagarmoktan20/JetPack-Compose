package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.ui.theme.greenJc

@Composable
fun Setting(){
    ConstraintLayout {
        val(redButton,greenButton,blueButton,blackButton) = createRefs()
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier.constrainAs(redButton){
            top.linkTo(parent.top, margin = 16.dp)
            width = Dimension.matchParent
            height = Dimension.value(100.dp)
        }) {
            Text(text = "Red")
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Green),modifier = Modifier.constrainAs(greenButton){
            top.linkTo(redButton.bottom)
            width = Dimension.wrapContent
        }) {
            Text(text = "Green")
        }
     createHorizontalChain(greenButton,blueButton, chainStyle = ChainStyle.Packed)
        val guideLine = createGuidelineFromBottom(0.01f)

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Blue), modifier = Modifier.constrainAs(blueButton){
            top.linkTo(greenButton.bottom)
        }) {
            Text(text = "Blue")
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color.Black), modifier = Modifier.constrainAs(blackButton){
            top.linkTo(blueButton.bottom)
            bottom.linkTo(guideLine)
        }) {
            Text(text = "Black")
        }
    }

//    Box(modifier = Modifier.fillMaxSize()) {
//        Column(modifier = Modifier.fillMaxSize().align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
//            Text(text = "Setting Screen", fontSize = 30.sp, color = greenJc)
//        }
//    }
}

@Preview
@Composable
fun settingPreview(){
    JetpackComposeTheme {
        Setting()
    }
}