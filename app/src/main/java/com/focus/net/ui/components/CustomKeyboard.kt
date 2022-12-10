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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import  androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.substring
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.focus.net.ui.viewmodel.MainViewModel
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
fun DisplayDigit(digits: String, position: Int = 3) {
    var firstText = digits.substring(0, position)
    var letterPost = if (position > 2) position + 1 else position

    var posText = digits.substring(letterPost , letterPost + 1)
    var restText = ""

    restText = if (position < ( digits.length + 1)) {
        digits.substring(letterPost + 1, digits.length)
    } else {
        digits.substring(digits.length)
    }
    Log.e("Digits", digits)

    Text(
        text = buildAnnotatedString {
            append(firstText)
              withStyle(
                  style = SpanStyle(
                      color = Color.Green,
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
















