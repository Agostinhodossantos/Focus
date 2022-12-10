package com.focus.net.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


class MainViewModelTest {

    private val viewModel = MainViewModel()
    @get:Rule
    var testRule = InstantTaskExecutorRule()

    @Test
    fun mainViewModel_Digits_IsSetCorrectly() {
        viewModel.addDigits(1)
        viewModel.addDigits(3)
        var currentDigits = viewModel.digits.value

        assertEquals(DIGITS_AFTER_UPDATE, currentDigits)
    }

    @Test
    fun mainViewModel_IncorrectDigits_ErrorFlagSet() {
        viewModel.addDigits(3)
        viewModel.addDigits(1)
        var incorrect = viewModel.digits.value

        assertNotEquals(incorrect[0], INCORRECT_DIGITS)
    }

    @Test
    fun mainViewModel_TimerState_Running() {

        var isNotRunning = viewModel.isPlaying.value
        viewModel.handleCountDownTimer()
        var isRunning = viewModel.isPlaying.value

        assertEquals(isNotRunning, false)
        assertEquals(isRunning, true)
    }

    @Test
    fun mainViewModel_SetTime_ReturnCorrectValue() {
        viewModel.setTime(1000)
        var time = viewModel.time.value

        assertEquals(time, 1000L)
    }

    @Test
    fun mainViewModel_GetTimer_ReturnCorrectFormattedTime() {
        var currentTime = viewModel.currentTime.value
        viewModel.setTime(1000)

        assertEquals(currentTime, FORMATTED_INITIAL_TIME)
    }

    companion object {
        private val DIGITS_AFTER_UPDATE = mutableListOf(1, 3)
        private val INCORRECT_DIGITS = mutableListOf(3, 1)
        private const val FORMATTED_INITIAL_TIME = "00:00"
    }
}