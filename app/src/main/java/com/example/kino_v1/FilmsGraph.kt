package com.example.kino_v1

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.filmsGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.FILMS,
        route = "films"
    ) {
        composable(Route.FILMS) {
            Films(navController)
        }

        composable("films_details") {
            FilmsDetails(navController)
        }
    }
}