package com.rahul.mynews.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class DateTimeUtilTest {

    @Test
    fun `should return - when input format is incorrect`() {
        assertThat("-").isEqualTo(DateTimeUtil.getFormattedDate("2021-07-07"))
    }

    @Test
    fun `should return formatted date when input format is correct`() {
        assertThat("07 Jul, 2021 19:00").isEqualTo(DateTimeUtil.getFormattedDate("2021-07-07T19:00:00Z"))
    }
}