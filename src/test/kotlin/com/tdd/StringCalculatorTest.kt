package com.tdd

import org.junit.Test
import kotlin.test.assertEquals

class StringCalculatorTest {

    @Test
    fun shouldSumCorrectly_forTwoNumbersSeperatedByCommas() {
        assertEquals(3, StringCalculator().calculate("1,2"))
    }
}