package com.example.myapplication.common.routes


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.views.albums.view.DisplayScreen
import com.example.myapplication.views.homepage.view.HomeScreen
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route,
) {
    val viewModel : HomePageViewModel = viewModel<HomePageViewModel>()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(viewModel, navController)
        }
        composable(NavigationItem.Display.route) {
            DisplayScreen(viewModel, navController)
        }
    }
}