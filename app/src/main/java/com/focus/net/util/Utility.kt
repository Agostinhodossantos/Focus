package com.focus.net.util

import android.util.Log
import java.util.concurrent.TimeUnit

object Utility {

    //time to countdown - 1hr - 60secs
    //const val TIME_COUNTDOWN: Long = 60000L
    private const val TIME_FORMAT = "%02d:%02d"
    private const val TIME_FORMAT_FULL = "%02d:%02d:%02d"


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
        var nums = mutableListOf<Int>()
        nums.addAll(num)
        if (nums.size < 6) {
            repeat(  6 - nums.size) {
                nums.add(0)
            }
        }
       // nums.reverse()
        var HH = "${nums[0]}${nums[1]}".toInt();
        var MM = "${nums[2]}${nums[3]}".toInt();
        var SS = "${nums[4]}${nums[5]}".toInt();

        val timeInHHMMSS = String.format(TIME_FORMAT_FULL, HH, MM,SS)
        return timeInHHMMSS;
    }

    fun getCursorIndex(index: Int): Pair<Int, Boolean> {
        if (index == 0) {
            return Pair(index, false)
        }
        if ((index + 1) % 3 == 0) {
            return Pair((index + 1), true)
        }
        return Pair(index, false)
    }


}

fun main() {
    repeat(10) {
        var pos = it + 1
        if (pos % 3 == 0) {
            println(pos)
        }
    }
}