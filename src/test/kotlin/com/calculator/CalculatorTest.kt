package com.calculator

import com.calculator.exception.DelimiterAtTheEndException
import com.calculator.exception.InvalidDelimiterException
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class CalculatorTest {

    private val calculator = Calculator(CalculatorTokenizer(NegativeNumberFinder()))

    companion object {
        @JvmStatic
        fun calculatorInputs() = listOf(
            Arguments.of("", 0),
            Arguments.of("1", 1),
            Arguments.of("2", 2),
            Arguments.of("1,2", 3),
            Arguments.of("3,2", 5),
            Arguments.of("3\n2,1", 6),
            Arguments.of("//;\n1;3", 4),
            Arguments.of("//|\n1|2|3", 6),
            Arguments.of("//sep\n2sep5", 7),
        )

        @JvmStatic
        fun calculatorInvalidDelimiterInputs() = listOf(
            Arguments.of("//|\n1|2;3", "'|' expected but ';' found at position 3."),
            Arguments.of("//|\n1|2,3", "'|' expected but ',' found at position 3."),
            Arguments.of("//,\n1,2|3", "',' expected but '|' found at position 3."),
            Arguments.of("//#\n1!2#3", "'#' expected but '!' found at position 1."),
        )
    }

    @MethodSource("calculatorInputs")
    @ParameterizedTest
    fun testCalculate(input: String, expected: Int) {
        val result = calculator.calculate(input)
        assertEquals(expected, result)
    }

    @MethodSource("calculatorInvalidDelimiterInputs")
    @ParameterizedTest
    fun testCalculateWithInvalidDelimiters(input: String, exceptionMessage: String) {
        val exception = assertThrows<InvalidDelimiterException> {
            calculator.calculate(input)
        }
        assertEquals(exceptionMessage, exception.message)
    }

    @Test
    fun `should raise exception for delimiter at the end`() {
        val calculator = Calculator(mockk())
        assertThrows<DelimiterAtTheEndException> {
            calculator.calculate("1,2,")
        }
    }

    @Test
    fun `should ignore numbers more than 1000`() {
        assertEquals(1, calculator.calculate("1,2000"))
    }
}