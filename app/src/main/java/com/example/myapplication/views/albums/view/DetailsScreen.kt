package com.example.myapplication.views.albums.view


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.views.homepage.data.models.ItunesModel
import com.example.myapplication.views.homepage.viewmodel.EntityType
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun DisplayScreen(viewModel : HomePageViewModel){
    val mapVal : Map<EntityType, ItunesModel> = viewModel.responseModels
    Log.i("Map size", mapVal.size.toString())
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =  Arrangement.Center
        ) {
            Text("Welcome")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayScreenPreview(){
    DisplayScreen(viewModel = HomePageViewModel())
}
