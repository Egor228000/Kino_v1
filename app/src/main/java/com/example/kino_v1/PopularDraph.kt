package com.example.kino_v1

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation


fun NavGraphBuilder.popularGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.POPULAR,
        route = "popular"
    ) {
        composable(Route.POPULAR) {
            Popular(navController)
        }

        composable("popular_details") {
            PopularDetails(navController)
        }
    }
}
