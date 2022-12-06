package com.focus.net.ui.util

import java.util.concurrent.TimeUnit

object Utility {
    const val TIME_COUNTDOWN: Long = 60000L
    private const val TIME_FORMAT = "%02d:%02d"

    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MICROSECONDS.toMinutes(this),
        TimeUnit.MICROSECONDS.toSeconds(this) % 60
    )
}