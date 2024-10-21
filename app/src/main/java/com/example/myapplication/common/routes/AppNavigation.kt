package com.example.myapplication.common.routes

enum class Screen{
    HomeScreen,
    DisplayScreen
}

sealed class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HomeScreen.name)
    data object Display : NavigationItem(Screen.DisplayScreen.name)
}