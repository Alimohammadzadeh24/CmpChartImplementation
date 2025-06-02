package org.alimmz.cmp.chart_implementation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cmpchartimplementation.composeapp.generated.resources.Res as R
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cmpchartimplementation.composeapp.generated.resources.ic_home
import cmpchartimplementation.composeapp.generated.resources.ic_chart_line
import org.alimmz.cmp.chart_implementation.navigation.Screen
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = Screen.getRoute(currentDestination?.route)

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Icon(
                            vectorResource(
                                R.drawable.ic_home
                            ), contentDescription = "Home"
                        )
                    },
                    label = { Text(Screen.Home.title) },
                    selected = currentScreen == Screen.Home,
                    onClick = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            vectorResource(
                                R.drawable.ic_chart_line
                            ), contentDescription = "Charts"
                        )
                    },
                    label = { Text(Screen.Charts.title) },
                    selected = currentScreen == Screen.Charts,
                    onClick = {
                        navController.navigate(Screen.Charts.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Charts.route) {
                ChartsScreen()
            }
            composable(Screen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Home Screen")
    }
}

@Composable
fun ChartsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Charts Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Settings Screen")
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    MaterialTheme {
        App()
    }
}