package com.focus.net.util

import com.focus.net.util.Utility.getDigitsDisplay
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UtilityTest {

    @Test
    fun `List of digits displayed correctly`() {
        var digits = mutableListOf(0,2,0,0,0,0)
        var display = getDigitsDisplay(digits)
        var expected = "02:00:00"

        assertThat(display).isEqualTo(expected)
    }

    @Test
    fun `List of incomplete digits is auto corrected`() {
        var digits = mutableListOf(0,2,0,0)
        var display = getDigitsDisplay(digits)
        var expected = "02:00:00"

        assertThat(display).isEqualTo(expected)
    }
}