package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        val inputList = inputs.split(",", "\n").toMutableList()
        val inputNumbers: List<Long>
        try {
            inputNumbers = inputList.map { it.toLong() }
        } catch (e: Exception) {
            throw InvalidNumberException(e.message)
        }
        return inputNumbers.sum()
    }

    class InvalidNumberException(msg: String?) : Exception(msg)
}
