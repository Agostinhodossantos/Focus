package com.focus.net.util

import com.focus.net.util.Utility.getCursorIndex
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

    @Test
    fun `Utility get display position` () {
        var firstIndex = getCursorIndex(1);
        var secondIndex = getCursorIndex(5);
        var thirdndex = getCursorIndex(6);

        assertThat(firstIndex).isEqualTo(FIRST_INDEX_SHOULD_BE)
        assertThat(secondIndex).isEqualTo(SECOND_INDEX_SHOULD_BE)
        assertThat(thirdndex).isEqualTo(THIRD_INDEX_SHOULD_BE)
    }

    companion object {
        const val FIRST_INDEX_SHOULD_BE = 1
        const val SECOND_INDEX_SHOULD_BE = 5
        const val THIRD_INDEX_SHOULD_BE = 7
    }
}