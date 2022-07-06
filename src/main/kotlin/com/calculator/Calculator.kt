package com.calculator

import com.calculator.exception.DelimiterAtTheEndException

class Calculator(private val tokenizer: CalculatorTokenizer) {
    fun calculate(s: String): Int {
        if (s == "")
            return 0
        if (!s.last().isDigit())
            throw DelimiterAtTheEndException()

        val (input, delimiters) = getInputAndDelimiter(s)
        val tokens = tokenizer.tokenize(input, delimiters)

        return sumListOfStringNumbers(tokens)
    }


    private fun getInputAndDelimiter(s: String): Pair<String, Array<String>> {
        if (s.startsWith("//")) {
            val delimiters = arrayOf(s.drop(2).substringBefore("\n"))
            val input = s.substringAfter("\n")
            return input to delimiters
        }
        return s to arrayOf(",", "\n")
    }


    private fun sumListOfStringNumbers(tokens: List<String>): Int =
        tokens.map { it.toInt() }.filter { it <= 1000 }.fold(0) { acc, s ->
            s + acc
        }
}
