package com.example.kino_v1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = Color(0xFF19082C)) {
        NavigationTree.values().forEach { tree ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = tree.image) , contentDescription ="" ) },
                selectedContentColor = Color.White,
                label = { Text(text = tree.name,)},
                alwaysShowLabel = false,
                unselectedContentColor = Color(0xFF4B2B83),

                selected = currentDestination?.hierarchy?.any { it.route == tree.route } == true,
                onClick = {
                    when (currentDestination?.hierarchy?.any { it.route == tree.route } == true) {
                        true -> {
                            if (currentDestination?.route != tree.startDestinationRoute) {
                                navController.navigate(route = tree.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        inclusive = false
                                    }
                                }
                            }
                        }
                        else -> navController.switchTabs(tree.route)
                    }
                }
            )
        }
    }
}
