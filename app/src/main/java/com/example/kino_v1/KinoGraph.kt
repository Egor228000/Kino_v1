package com.example.kino_v1

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.kinoGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.KINO,
        route = "kino"
    ) {
        composable(Route.KINO) {
            Kino(navController)
        }

        composable("kino_details") {
            KinoDetails(navController)
        }
    }
}