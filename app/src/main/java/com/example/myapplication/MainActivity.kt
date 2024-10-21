package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.views.homepage.view.HomeScreen
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: HomePageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                HomeScreen(viewModel)
            }
        }
    }
}


