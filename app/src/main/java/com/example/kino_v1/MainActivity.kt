package com.example.kino_v1

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomNav(navController) },
                content = { innerPadding ->
                    FirebaseApp.initializeApp(LocalContext.current)

                    NavHost(
                        navController = navController,
                        startDestination = Route.PROFILE_ROOT,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        popularGraph(navController)
                        filmsGraph(navController)
                        kinoGraph(navController)
                        ticketGraph(navController)
                        profileGraph(navController)
                    }
                }
            )
        }
    }
}