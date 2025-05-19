package com.example.jetpackcompose

sealed class Screens(val screens : String){

    data object Home: Screens("ome")
    data object Profile: Screens("rofile")
    data object Setting: Screens("etting")
    data object search: Screens("earch")
    data object Notification: Screens("otification")
    data object Post: Screens("ost")

}