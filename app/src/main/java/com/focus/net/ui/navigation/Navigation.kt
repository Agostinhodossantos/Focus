package com.focus.net.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.focus.net.ui.screens.FocusModeScreen
import com.focus.net.ui.screens.MainScreen
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
            MainScreen(modifier = Modifier)
        }

        composable(FOCUS_MODE) {
            FocusModeScreen()
        }

        composable(TIMER_MODE) {
            TimerModeScreen()
        }

    }
}