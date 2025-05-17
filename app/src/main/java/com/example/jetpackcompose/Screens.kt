package com.example.jetpackcompose

sealed class Screens(val screens : String){

    data object Home: Screens("Home")
    data object Profile: Screens("rofile")
    data object Setting: Screens("Setting")

}