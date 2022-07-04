package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        if (inputs.endsWith(",") || inputs.endsWith("\n"))
            throw DelimiterPositionException("Delimiter must not be at the end!")
        val inputList = inputs.split(",", "\n")
        val inputNumbers: List<Long>
        try {
            inputNumbers = inputList.map { it.toLong() }
        } catch (e: Exception) {
            throw InvalidNumberException(e.message)
        }
        return inputNumbers.sum()
    }

    class InvalidNumberException(msg: String?) : Exception(msg)

    class DelimiterPositionException(msg: String?) : Exception(msg)
}
