package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        val inputList = inputs.split(delimiters = arrayOf(","), ignoreCase = false, limit = 0)
        val inputNumbers: List<Long>
        try {
            inputNumbers = inputList.map { it.toLong() }
        } catch (e: Exception) {
            throw InvalidNumberException(e.message)
        }
        if (inputNumbers.size < 2)
            return inputNumbers[0]
        return inputNumbers[0].plus(inputNumbers[1])
    }

    class InvalidNumberException(msg: String?) : Exception(msg)
}
