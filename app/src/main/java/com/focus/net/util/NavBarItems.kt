package com.focus.net.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.focus.net.model.BarItem
import com.focus.net.ui.navigation.NavRoutes

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Focus Mode",
            image = Icons.Filled.Home,
            route = HOME
        ),
        BarItem(
            title = "Timer Mode",
            image = Icons.Filled.Notifications,
            route = TIMER_MODE
        ),
        BarItem(
            title = "Full Screen",
            image = Icons.Filled.Favorite,
            route = FULL_SCREEN
        ),
        BarItem(
            title = "Music",
            image = Icons.Filled.Share,
            route = MUSIC
        )
    )
}