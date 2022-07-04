package com.tdd

import org.junit.Test
import kotlin.test.assertEquals

class StringCalculatorTest {

    @Test
    fun shouldSumCorrectly_forTwoNumbersSeperatedByCommas() {
        assertEquals(3, StringCalculator().calculate("1,2"))
    }

    @Test
    fun shouldReturnZero_forEmptyString() {
        assertEquals(0, StringCalculator().calculate(""))
    }

    @Test
    fun shouldReturnInput_forOneNumberProvided() {
        assertEquals(2, StringCalculator().calculate("2"))
    }
}