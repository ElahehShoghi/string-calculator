package com.calculator

import com.calculator.exception.CalculatorException
import com.calculator.exception.InvalidDelimiterException
import com.calculator.exception.NegativeNumbersException


class CalculatorTokenizer(private val negativeNumberFinder: NegativeNumberFinder) {
    fun tokenize(input: String, delimiters: Array<String>): List<String> {
        val tokens = input.split(*delimiters)
        validateTokens(tokens, input, delimiters)
        return tokens
    }

    private fun validateTokens(tokens: List<String>, input: String, delimiters: Array<String>) {
        val delimiterValidationResult = runCatching { validateDelimiters(tokens, delimiters, input) }
        negativeNumberFinder.findNegativeNumbers(tokens)?.let {
            val negativeException = NegativeNumbersException(it)
            delimiterValidationResult.onFailure {
                throw CalculatorException(negativeException, it)
            }
            throw NegativeNumbersException(it)
        }
        delimiterValidationResult.getOrThrow()
    }


    private fun validateDelimiters(tokens: List<String>, delimiters: Array<String>, input: String) {
        findFirstInvalidChar(tokens)?.let { invalidChar ->
            throw InvalidDelimiterException(delimiters.first(), invalidChar.toString(), input.indexOf(invalidChar))
        }
    }

    private fun findFirstInvalidChar(tokens: List<String>): Char? {
        return tokens.firstNotNullOfOrNull {
            it.firstOrNull { !it.isDigit() && it != '-' }
        }
    }

}
