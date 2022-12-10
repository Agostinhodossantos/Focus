package com.focus.net.ui.components

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import  androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.focus.net.ui.viewmodel.MainViewModel
import com.focus.net.util.Utility.getCursorIndex
import com.focus.net.util.Utility.getDigitsDisplay
import com.focus.net.util.Utility.getNumbersList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomKeyboard(modifier: Modifier = Modifier, viewModel: MainViewModel =viewModel()) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        //columns = GridCells.Adaptive(minSize = 130.dp)
    ) {
       items(getNumbersList()) {
           ButtonNumber(symbol = it.toString(), onClick = { digit ->
               viewModel.addDigits(digit.toInt())
               Log.e("HELLO", digit.toString())
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
    onClick: (num: String) -> Unit,
    viewModel: MainViewModel =viewModel()
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
fun DisplayDigit(digits: String, position: Int) {
    var jump by remember { mutableStateOf(0) }
    var posText by remember { mutableStateOf("") }
    var restText by remember { mutableStateOf("") }
    var firstText by remember { mutableStateOf("") }

    val infiniteTransition = rememberInfiniteTransition()

    val fading by infiniteTransition.animateFloat(
        initialValue = 1f ,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(500),
            repeatMode = RepeatMode.Reverse
        )
    )


    var indexPosition = jump + position
    var index = getCursorIndex(indexPosition)

    if (index.second) {
        jump += 1
    }

    if (index.first + 2 <= digits.length) {
        firstText = digits.substring(0, indexPosition)
        posText = digits.substring(index.first , index.first + 1)
        restText = digits.substring(index.first + 1, digits.length)
    }
    Log.e("Digits", digits)
    Text(
        text = buildAnnotatedString {
            append(firstText)
              withStyle(
                  style = SpanStyle(
                      color = Color.Green.copy(alpha = fading),
                  )
              ) {
                  append(posText)
              }
            append(restText)
        },
        fontWeight = FontWeight.Bold,
        fontSize = 80.sp,
        color = Color.White
    )
}
















