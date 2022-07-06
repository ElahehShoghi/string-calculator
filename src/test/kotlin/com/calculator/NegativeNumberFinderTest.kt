package com.calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NegativeNumberFinderTest {
    @Test
    fun `should find negative numbers`() {
        val tokens = listOf("1", "2,-3")
        val negativeNumbers = NegativeNumberFinder().findNegativeNumbers(tokens)
        assertEquals(listOf("-3"), negativeNumbers)
    }
}