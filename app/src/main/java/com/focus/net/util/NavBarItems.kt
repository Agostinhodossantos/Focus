package com.focus.net.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import com.focus.net.model.BarItem
import com.focus.net.ui.navigation.NavRoutes

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = HOME
        ),
        BarItem(
            title = "Focus Mode",
            image = Icons.Filled.Face,
            route = FOCUS_MODE
        ),
        BarItem(
            title = "Timer Mode",
            image = Icons.Filled.Face,
            route = TIMER_MODE
        ),
        BarItem(
            title = "Full Screen",
            image = Icons.Filled.Favorite,
            route = FULL_SCREEN
        ),
        BarItem(
            title = "Music",
            image = Icons.Filled.Favorite,
            route = MUSIC
        )
    )
}