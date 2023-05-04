package com.example.kino_v1

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationTree(
    @StringRes val displayName: Int,
    val image: Int,
    val route: String,
    val startDestinationRoute: String
) {
    Популярное(R.string.bottom_nav_popular, R.drawable.baseline_star_24, Route.POPULAR_ROOT, Route.POPULAR),
    Фильмы(R.string.bottom_nav_films, R.drawable.baseline_local_movies_24, Route.FILMS_ROOT, Route.FILMS),
    Кинотеатры(R.string.bottom_nav_kino, R.drawable.baseline_movie_filter_24, Route.KINO_ROOT, Route.KINO),
    Билеты(R.string.bottom_nav_ticket, R.drawable.baseline_local_activity_24, Route.TICKET_ROOT, Route.TICKET),
    Профиль(R.string.bottom_nav_profile, R.drawable.baseline_person_24, Route.PROFILE_ROOT, Route.PROFILE)
}
