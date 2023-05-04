package com.example.kino_v1

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.profileGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.PROFILE,
        route = "profile"
    ) {
        composable(Route.PROFILE) {
            Profile(navController, LocalContext.current)
        }

        composable("profile_details") {
            ProfileDetails(navController)
        }
        composable("profile_email") {
            ProfileEmail(navController)
        }
        composable("profile_phone") {
            ProfilePhone(navController)
        }
        composable("profile_registr") {
            ProfileRegistr(navController)
        }
    }
}