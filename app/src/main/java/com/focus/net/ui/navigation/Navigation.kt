package com.focus.net.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.focus.net.ui.screens.Home
import com.focus.net.ui.screens.FocusModeScreen
import com.focus.net.ui.screens.TimerModeScreen
import com.focus.net.util.FOCUS_MODE
import com.focus.net.util.HOME
import com.focus.net.util.TIMER_MODE

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        NavRoutes.Home.route
    ) {
        composable(HOME) {
            Home()
        }

        composable(FOCUS_MODE) {
            FocusModeScreen()
        }

        composable(TIMER_MODE) {
            TimerModeScreen()
        }

    }
}