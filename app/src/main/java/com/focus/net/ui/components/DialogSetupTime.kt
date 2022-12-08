package com.focus.net.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogSetupTime(modifier: Modifier = Modifier, getTime: (time: String) -> Unit) {
    var time by remember { mutableStateOf("20:00") }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Modo do timer",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 10.dp))

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = time,
                onValueChange = {
                    time = it
                })

            Spacer(modifier = Modifier.height(15.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                    getTime(time)
                }) {
                Text(text = "Adicionar")
            }
            Spacer(modifier = Modifier.height(15.dp))

        }
    }
}

@Composable
fun ButtonSetTimer(
    getTime: (time: String) -> Unit
) {
    var popupControl by remember { mutableStateOf(false) }

    TextButton(onClick = { popupControl = true },
        modifier = Modifier
            .height(60.dp)
            .padding(top = 10.dp)
            .wrapContentWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black)) {
        Icon(
            imageVector = Icons.Filled.LocationOn,
            contentDescription = "Start",
            tint = Color.Black,
            modifier = Modifier.size(26.dp)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = "Definir o tempo",
        )
    }
    if (popupControl) {
        Popup(
            alignment = Alignment.Center,
//            offset = IntOffset(0, 700),
            onDismissRequest = { popupControl = false },
        ) {
            DialogSetupTime(getTime = {
                popupControl = false
                getTime(it)
            })

        }
    }

}