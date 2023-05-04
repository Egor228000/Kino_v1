package com.example.kino_v1

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation


fun NavGraphBuilder.ticketGraph(navController: NavHostController) {
    navigation(
        startDestination = Route.TICKET,
        route = "ticket"
    ) {
        composable(Route.TICKET) {
            Ticket(navController)
        }

        composable("ticket_details") {
            TicketDetails(navController)
        }

    }
}