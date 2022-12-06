package com.focus.net.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountDownButton(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    optionSelected: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 90.dp)
    ) {
        Button(onClick = {
            optionSelected()
        },modifier = Modifier
            .height(70.dp)
            .width(200.dp),
            shape = RoundedCornerShape(25.dp),

            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
            )
        ) {
            val pair = if (!isPlaying) {
                "START"
            } else {
                "STOP"
            }
            
            Text(
                text = pair,
                fontSize = 20.sp,
                color = Color.White,
            )

        }
    }
}