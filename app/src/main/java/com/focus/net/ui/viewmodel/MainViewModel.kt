package com.focus.net.ui.viewmodel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.focus.net.util.Utility
import com.focus.net.util.Utility.formatTime

class MainViewModel : ViewModel() {
    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableLiveData(0L)
    val time: LiveData<Long> = _time

    private val _currentTime = MutableLiveData(time.value!!.formatTime())
    val currentTime: LiveData<String> = _currentTime

    private val _progress = MutableLiveData(1.00F)
    val progress: LiveData<Float> = _progress

    private val _isPlaying = MutableLiveData(false)
    val isPlaying: LiveData<Boolean> = _isPlaying

    fun handleCountDownTimer() {
        if (isPlaying.value == true) {
            pauseTimer()
        } else {
            startTimer()
        }
    }

    private fun pauseTimer() {
        countDownTimer?.cancel()
        handleTimerValues(false, time.value!!.formatTime(), 1.0F, false)
    }

    private fun startTimer() {
        _isPlaying.value = true
        countDownTimer = object  : CountDownTimer(time.value!!, 1000) {
            override fun onTick(millisRemaining: Long) {
                Log.d("LONG", millisRemaining.toString())
                val progressValue = millisRemaining.toFloat() / time.value!!
                handleTimerValues(true, millisRemaining.formatTime(), progressValue, false)
            }

            override fun onFinish() {
               pauseTimer()
            }
        }.start()
    }

    private fun handleTimerValues(isPlaying: Boolean, text: String, progress: Float, celebrate: Boolean) {
        Log.e("TIMER", text.toString() )
        _isPlaying.value = isPlaying
        _currentTime.value = text
        _progress.value = progress
    }

    fun setTime(time: Long) {
        _time.value = time
    }

}