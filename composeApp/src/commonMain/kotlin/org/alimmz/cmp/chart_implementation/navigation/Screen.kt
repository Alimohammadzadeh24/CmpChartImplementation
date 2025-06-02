package org.alimmz.cmp.chart_implementation.navigation

sealed class Screen(val route: String, val title: String) {
    data object Home : Screen("home", "Home")
    data object Charts : Screen("charts", "Charts")
    data object Settings : Screen("settings", "Settings")

    companion object {
        fun getRoute(route: String?): Screen = when (route) {
            Home.route -> Home
            Charts.route -> Charts
            Settings.route -> Settings
            else -> Home
        }
    }
}