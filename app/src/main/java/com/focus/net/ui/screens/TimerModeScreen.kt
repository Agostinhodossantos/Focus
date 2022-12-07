package com.focus.net.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.window.Popup

@Composable
fun TimerModeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        var popupControl by remember {
            mutableStateOf(false)
        }
        TextButton(onClick = { popupControl = true }) {
            Text(text = "Open normal popup",)
        }
        if (popupControl) {
            Popup(
                alignment = Alignment.CenterStart,
                offset = IntOffset(0, 700),
                onDismissRequest = { popupControl = false }
            ) {
                Text(text = "Im pop up")
            }
        }
    }
}