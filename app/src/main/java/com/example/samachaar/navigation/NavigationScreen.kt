package com.example.samachaar.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.samachaar.screens.MainScreen
import com.example.samachaar.screens.WallpaperScreen
import com.example.samachaar.screens.main.MainScreenViewModel
import com.example.samachaar.screens.selectCountry.selectCountry

@Composable
fun NavigationScreens() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NewsScreens.CountrySelectorPage.name
    ) {
        val route = NewsScreens.NewsPage.name
        composable(
            route = "$route/{countryCode}",
            arguments = listOf(navArgument(name = "countryCode") {
                type = NavType.StringType
            })
        ) { navBack ->
            navBack.arguments?.getString("countryCode").let { countryCode ->
                val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
                MainScreen(
                    mainScreenViewModel,
                    navController = navController,
                    countryCode = countryCode
                )
            }
        }
        composable(route = NewsScreens.CountrySelectorPage.name) {
            selectCountry(navController = navController)
        }
        composable(route = NewsScreens.WallpaperScreen.name){
            WallpaperScreen()
        }

    }
}