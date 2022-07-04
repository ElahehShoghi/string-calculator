package com.tdd

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    fun shouldSumCorrectly_forTwoNumbersSeperatedByCommas() {
        assertEquals(3, stringCalculator.calculate("1,2"))
        assertEquals(13, stringCalculator.calculate("11,2"))
    }

    @Test
    fun shouldReturnZero_forEmptyString() {
        assertEquals(0, stringCalculator.calculate(""))
    }

    @Test
    fun shouldReturnInput_forOneNumberProvided() {
        assertEquals(2, stringCalculator.calculate("2"))
    }

    @Test
    fun shouldRaiseNumberFormatException_forInvalidNumbers() {
        assertFailsWith<StringCalculator.InvalidNumberException> {
            stringCalculator.calculate("2,\n3")
            stringCalculator.calculate("hi,2")
        }
    }

    @Test
    fun shouldWorkCorrectly_forNewlineSeparator() {
        assertEquals(15, stringCalculator.calculate("14\n1"))
    }

    @Test
    fun shouldWorkCorrectly_forNewlinesAndCommasAsSeparatorTogether() {
        assertEquals(25, stringCalculator.calculate("10,14\n1"))
        assertEquals(25, stringCalculator.calculate("10\n14,1"))
    }

    @Test
    fun shouldRaiseDelimiterPositionException_forInputsWithDelimiterAtTheEnd() {
        assertFailsWith<StringCalculator.DelimiterPositionException> {
            stringCalculator.calculate("1,2\n")
            stringCalculator.calculate("1,2,")
        }
    }

    @Test
    fun shouldWorkCorrectly_forDelimitersSpecifiedInInput() {
        assertEquals(4, stringCalculator.calculate("//;\n1;3"))
    }
}