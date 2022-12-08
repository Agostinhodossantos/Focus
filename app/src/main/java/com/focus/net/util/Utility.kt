package com.focus.net.util

import java.util.concurrent.TimeUnit

object Utility {

    //time to countdown - 1hr - 60secs
    //const val TIME_COUNTDOWN: Long = 60000L
    private const val TIME_FORMAT = "%02d:%02d"


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


}