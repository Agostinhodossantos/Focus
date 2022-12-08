package com.focus.net.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.focus.net.ui.components.CustomKeyboard
import com.focus.net.ui.components.DisplayDigit

@Composable
fun KeyboardScreen() {
    Column(
        modifier = Modifier.background(Color(0xFF0A0A0A)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        DisplayDigit()
        CustomKeyboard()
    }
}