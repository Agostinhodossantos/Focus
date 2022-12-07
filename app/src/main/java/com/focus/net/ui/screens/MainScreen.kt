package com.focus.net.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.focus.net.ui.components.BottomNavigationBar
import com.focus.net.ui.components.Home
import com.focus.net.ui.navigation.NavigationHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier) {
    val navController = rememberNavController()

    Scaffold(
      topBar = { TopAppBar(title = { Text("Bottom Navigation")}) },
        content = { NavigationHost(navController = navController)},
        bottomBar = { BottomNavigationBar(navController) }
    )
}