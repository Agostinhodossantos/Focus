package com.focus.net.ui.navigation

import com.focus.net.util.*

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes(HOME)
    object FocusMode : NavRoutes(FOCUS_MODE)
    object TimerMode : NavRoutes(TIMER_MODE)
    object FullScreen : NavRoutes(FULL_SCREEN)
    object Music : NavRoutes(MUSIC)
}
