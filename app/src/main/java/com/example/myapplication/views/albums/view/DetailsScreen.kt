package com.example.myapplication.views.albums.view


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun DisplayScreen(viewModel: HomePageViewModel, navController: NavController) {
//    val mapVal: Map<EntityType, ItunesModel> = viewModel.responseModels
    var selectedIndex by remember { mutableIntStateOf(1) }
    val tabs = listOf("Grid Layout", "List Layout")
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("iTunes")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },

                )
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(
                top = innerPadding.calculateTopPadding()
            ),
        ) {
            TabRow(
                containerColor = Color.White,
                selectedTabIndex = selectedIndex,
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .clip(RoundedCornerShape(25))
                    .padding(1.dp).fillMaxWidth().background(Color.Red),
                indicator = {
                    Box{}
                }
                ) {
                tabs.forEachIndexed { index, title ->
                    val selected = selectedIndex == index
                    Tab(
                        modifier = if (selected) Modifier
                            .clip(RoundedCornerShape(25))
                            .background(
                                Color.Gray
                            )
                        else Modifier
                            .clip(RoundedCornerShape(25))
                            .background(
                                Color(
                                    0xff1E76DA
                                )
                            ),
                        selected = selected,
                        onClick = { selectedIndex = index },
                        text = { Text(title, color = Color.Black) }
                    )
                }
            }
            when(selectedIndex){
                0 -> AlbumGridView()
                1 -> AlbumListView(items = viewModel.responseModels)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayScreenPreview() {
    DisplayScreen(viewModel = HomePageViewModel(), rememberNavController())
}


