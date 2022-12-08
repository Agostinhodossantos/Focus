package com.focus.net.ui.components

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.focus.net.util.Utility.getNumbersList

@Composable
fun CustomKeyboard(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        //columns = GridCells.Adaptive(minSize = 130.dp)
    ) {
       items(getNumbersList()) {
           ButtonNumber(symbol = it.toString(), onClick = {
               Log.e("HELLO", it.toString())
           })
       }
        item {
            ButtonNumber(symbol = "0", onClick = {
                Log.e("HELLO", it.toString())
            })
        }
        item {
            ButtonNumber(symbol = "DEL", onClick = {
                Log.e("HELLO", it.toString())
            })
        }
    }
}

@Composable
fun ButtonNumber(
    modifier: Modifier = Modifier,
    symbol: String,
    onClick: (num: String) -> Unit
) {
    Button(
        modifier = modifier
            .padding(10.dp)
            .size(80.dp),
        shape = CircleShape,
        onClick = {
        onClick(symbol)
    }) {
        Text(
            text = symbol,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}


@Composable
fun DisplayDigit() {
    Text(
        text = "20:00:00",
        fontWeight = FontWeight.Bold,
        fontSize = 80.sp,
        color = Color.White
    )
}
















