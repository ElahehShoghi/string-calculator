package com.tdd

class StringCalculator {

    fun calculate(_inputs: String): Long {
        var inputs = _inputs
        if (inputs.trim() == "")
            return 0
        if (inputs.endsWith(",") || inputs.endsWith("\n"))
            throw DelimiterPositionException("Delimiter must not be at the end!")
        var delimiters = arrayOf(",", "\n")
        if (inputs.startsWith("//") && inputs.contains("\n")) {
            delimiters = arrayOf(inputs.substringBefore("\n").substringAfter("//"))
            inputs = inputs.substringAfter("\n")
            val pattern = Regex("[0-9${delimiters[0]}]+")
            if (!inputs.matches(pattern))
                throw InvalidDelimiterException(
                    "'${delimiters[0]}' expected but '${inputs.replace(pattern, "")}' found."
                )
        }
        val numbers = inputs.split(*delimiters).map {
            try {
                it.toLong()
            } catch (e: Exception) {
                throw InvalidNumberException(e.message)
            }
        }
        val negativeNumbers = numbers.filter { it < 0 }
        if (negativeNumbers.isNotEmpty())
            throw NegativeNumbersNotAllowedException("Negative numbers not allowed: $negativeNumbers")
        return numbers.sumOf { if (it > 1000) 0 else it }
    }

    class InvalidNumberException(msg: String?) : Exception(msg)

    class DelimiterPositionException(msg: String?) : Exception(msg)

    class InvalidDelimiterException(msg: String) : Exception(msg)

    class NegativeNumbersNotAllowedException(msg: String) : Exception(msg)
}
