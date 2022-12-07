package com.focus.net.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun FocusModeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {

        var popupControl by remember {
            mutableStateOf(false)
        }
        TextButton(onClick = { popupControl = true }) {
            Text(text = "Open normal popup",)
        }
        if (popupControl) {
            Popup(
                alignment = Alignment.Center
            ) {
                Text(text = "Im pop up")
            }
        }
    }
}