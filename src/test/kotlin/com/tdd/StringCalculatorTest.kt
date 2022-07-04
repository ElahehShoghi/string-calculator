package com.tdd

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StringCalculatorTest {

    @Test
    fun shouldSumCorrectly_forTwoNumbersSeperatedByCommas() {
        assertEquals(3, StringCalculator().calculate("1,2"))
        assertEquals(13, StringCalculator().calculate("11,2"))
    }

    @Test
    fun shouldReturnZero_forEmptyString() {
        assertEquals(0, StringCalculator().calculate(""))
    }

    @Test
    fun shouldReturnInput_forOneNumberProvided() {
        assertEquals(2, StringCalculator().calculate("2"))
    }

    @Test
    fun shouldRaiseNumberFormatException_forInvalidNumbers() {
        assertFailsWith<StringCalculator.InvalidNumberException> {
            StringCalculator().calculate("hi,2")
        }
    }
}