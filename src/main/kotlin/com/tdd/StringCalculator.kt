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
        try {
            return inputs.split(*delimiters).sumOf { it.toLong() }
        } catch (e: Exception) {
            throw InvalidNumberException(e.message)
        }
    }

    class InvalidNumberException(msg: String?) : Exception(msg)

    class DelimiterPositionException(msg: String?) : Exception(msg)

    class InvalidDelimiterException(msg: String) : Exception(msg)
}
