package com.calculator.com.calculator

class Calculator {
    fun calculate(s: String): Int {
        if (s == "")
            return 0
        if (!s.last().isDigit())
            throw DelimiterAtTheEndException()

        val (input, delimiters) = getInputAndDelimiter(s)
        val tokens = tokenize(input, delimiters)

        validateTokens(tokens, delimiters.first(), input)

        return sumListOfStringNumbers(tokens)
    }

    private fun validateTokens(tokens: List<String>, delimiter: String, input: String) {
        tokens.forEach {
            val nonDigit = it.firstOrNull { !it.isDigit() }
            if (nonDigit != null)
                throw InvalidDelimiterException(delimiter, nonDigit.toString(), input.indexOf(nonDigit))
        }
    }

    private fun getInputAndDelimiter(s: String): Pair<String, Array<String>> {
        if (s.startsWith("//")) {
            val delimiters = arrayOf(s.drop(2).substringBefore("\n"))
            val input = s.substringAfter("\n")
            return input to delimiters
        }
        return s to arrayOf(",", "\n")
    }

    private fun tokenize(input: String, delimiters: Array<String>) =
        input.split(*delimiters)

    private fun sumListOfStringNumbers(tokens: List<String>): Int =
        tokens.fold(0) { acc, s ->
            s.toInt() + acc
        }
}
