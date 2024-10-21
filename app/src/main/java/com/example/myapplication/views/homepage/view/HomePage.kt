package com.example.myapplication.views.homepage.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.common.extensions.ToHeight
import com.example.myapplication.views.homepage.view.composables.EntityComposable
import com.example.myapplication.views.homepage.viewmodel.EntityType
import com.example.myapplication.views.homepage.viewmodel.HomePageState
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun HomeScreen(viewModel: HomePageViewModel) {
    var text by remember { mutableStateOf("") }
    val homePageState by viewModel.stateVal

    val entities = viewModel.entityList
    val ctx = LocalContext.current


    Scaffold(
        modifier = Modifier
            .background(
                color = Color.Black
            )
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp
                )
        ) {
            when (homePageState) {
                is HomePageState.HomePageLoading -> {
                    CircularProgressIndicator(

                    )
                }

                is HomePageState.HomePageFailure -> {
                    Text(text = (homePageState as HomePageState.HomePageFailure).msg)
                }

                is HomePageState.HomePageSuccess -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_settings_applications_24
                            ),
                            contentDescription = null
                        )
                        Text(text = "iTunes")
                    }
                    25.ToHeight()
                    Text(
                        "Search from a variety of contents from Itunes store including iBooks, movies, podcast, music, music videos and audiobooks"
                    )
                    20.ToHeight()
                    TextField(
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done,

                            ),
                        modifier = Modifier.fillMaxWidth(),
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = {
                            Text("Search by Artist/Album")
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.LightGray
                        )
                    )
                    Text(
                        "Specify the parameter for the content to be searched",
                        modifier = Modifier.padding(vertical = 25.dp)
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        LazyVerticalGrid(
                            verticalArrangement = Arrangement.Center,
                            horizontalArrangement = Arrangement.Center,
                            columns = GridCells.Fixed(count = 4)
                        ) {
                            items(entities) {
                                EntityComposable(entityItemModel = it)
                            }
                        }
                    }
                    20.ToHeight()
                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.LightGray
                            ),
                        onClick = {
                            val filteredList: List<EntityType> = entities.filter {
                                it.isSelected
                            }.map { it.name }
                            if (text.isEmpty() || filteredList.isEmpty()) {
                                Toast.makeText(ctx, "Please enter artist name", Toast.LENGTH_LONG)
                                    .show()
                            } else {
                                viewModel.getAlbumDetails(text, filteredList)
                            }
                        }
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    }

}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(viewModel = HomePageViewModel())
}
