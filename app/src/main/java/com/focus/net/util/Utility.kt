package com.focus.net.util

import android.util.Log
import java.util.concurrent.TimeUnit

object Utility {

    //time to countdown - 1hr - 60secs
    //const val TIME_COUNTDOWN: Long = 60000L
    private const val TIME_FORMAT = "%02d:%02d:%02d"


    //convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

    //List of button
    fun getNumbersList(): List<Int> {
        var numbers = mutableListOf<Int>()
        repeat(9) {
            numbers.add(it + 1)
        }
        return numbers
    }

    fun getDigitsDisplay(num: MutableList<Int>): String {
        // If num is its not complete add zeros
        if (num.size < 6) {
            repeat(  6 - num.size) {
                num.add(0)
            }
        }
        print(num)

        var HH = "${num[0]}${num[1]}".toInt();
        var MM = "${num[2]}${num[3]}".toInt();
        var SS = "${num[4]}${num[5]}".toInt();

        val timeInHHMMSS = String.format(TIME_FORMAT, HH, MM,SS)
        return timeInHHMMSS;
    }


}