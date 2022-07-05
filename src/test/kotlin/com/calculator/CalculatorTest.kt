package com.calculator.com.calculator

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class CalculatorTest {

    companion object{
        @JvmStatic
        fun calculatorInputs() = listOf(
            Arguments.of("", 0),
            Arguments.of("1", 1),
            Arguments.of("2", 2),
            Arguments.of("1,2", 3),
            Arguments.of("3,2", 5),
        )
    }

    @MethodSource("calculatorInputs")
    @ParameterizedTest
    fun testCalculate(input: String, expected: Int){
        val calculator = Calculator()
        val result = calculator.calculate(input)
        assertEquals(expected, result)
    }

}