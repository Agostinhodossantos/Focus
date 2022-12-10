package com.focus.net.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.focus.net.ui.components.CustomKeyboard
import com.focus.net.ui.components.DisplayDigit
import com.focus.net.ui.components.Pulsating
import com.focus.net.ui.viewmodel.MainViewModel
import com.focus.net.util.Utility

@Composable
fun KeyboardScreen(viewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier.background(Color(0xFF0A0A0A)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val digits = viewModel.digits.collectAsState()
        Spacer(modifier = Modifier.height(10.dp))
        DisplayDigit(Utility.getDigitsDisplay(digits.value), digits.value.size)
        CustomKeyboard()
    }
}