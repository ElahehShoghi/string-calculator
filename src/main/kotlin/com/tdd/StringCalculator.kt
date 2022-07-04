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
        }
        try {
            return inputs.split(*delimiters).sumOf { it.toLong() }
        } catch (e: Exception) {
            throw InvalidNumberException(e.message)
        }
    }

    class InvalidNumberException(msg: String?) : Exception(msg)

    class DelimiterPositionException(msg: String?) : Exception(msg)
}
