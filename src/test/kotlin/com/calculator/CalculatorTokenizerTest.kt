package com.calculator

import com.calculator.exception.CalculatorException
import com.calculator.exception.NegativeNumbersException
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class CalculatorTokenizerTest {

    companion object {
        @JvmStatic
        fun negativeNumbersArgument() = listOf(
            Arguments.of("1,-2", ",", "Negative number(s) not allowed: -2"),
            Arguments.of("-1,2", ",", "Negative number(s) not allowed: -1"),
            Arguments.of("-11|-4", "|", "Negative number(s) not allowed: -11, -4"),
        )

        @JvmStatic
        fun multipleErrorsArgument() = listOf(
            Arguments.of(
                "1|2,-3",
                "|",
                "Negative number(s) not allowed: -3\n'|' expected but ',' found at position 3."
            ),
            Arguments.of(
                "1|2,-3",
                ",",
                "Negative number(s) not allowed: -3\n',' expected but '|' found at position 1."
            ),
            Arguments.of(
                "1,2sep-3sep-4",
                "sep",
                "Negative number(s) not allowed: -3, -4\n'sep' expected but ',' found at position 1."
            ),
        )
    }

    @MethodSource("negativeNumbersArgument")
    @ParameterizedTest
    fun `should raise exception for negative numbers`(input: String, delimiter: String, exceptionMessage: String) {
        val exception = assertThrows<NegativeNumbersException> {
            CalculatorTokenizer(NegativeNumberFinder()).tokenize(input, arrayOf(delimiter))
        }
        assertEquals(exceptionMessage, exception.message)
    }

    @MethodSource("multipleErrorsArgument")
    @ParameterizedTest
    fun `should raise exception for multiple errors`(input: String, delimiter: String, exceptionMessage: String) {
        val exception = assertThrows<CalculatorException> {
            CalculatorTokenizer(NegativeNumberFinder()).tokenize(input, arrayOf(delimiter))
        }
        assertEquals(exceptionMessage, exception.message)
    }
}