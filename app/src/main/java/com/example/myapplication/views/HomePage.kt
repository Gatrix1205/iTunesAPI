package com.example.myapplication.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.myapplication.R


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun HomeScreen(){
    Scaffold(
        modifier = Modifier
            .background(
                color = Color.Black
            )
    ) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(
            horizontal = 16.dp
        )
    ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(
                        id = R.drawable.baseline_settings_applications_24
                    ),
                    contentDescription = null
                )
                Text(text = "iTunes")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Search from a variety of contents from Itunes store including books, movies, music, and more")
           Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = { }
            )
            Text(
                "Specify the parameter for the content to be searched",
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Box(
                modifier = Modifier
                    .background(color = Color.Cyan)
                    .padding(bottom = 12.dp)
            ) {

            }
            TextButton(
                modifier = Modifier.fillMaxWidth().background(
                    color = Color.Gray
                ),
                onClick = {

                }
            ) {
                Text(text = "Submit")
            }


        }
    }
}

@Composable
fun FilledButton(onClick: () -> Unit, content: () -> Unit) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
