package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        val inputList = inputs.split(delimiters = arrayOf(","), ignoreCase = false, limit = 0)
        val firstNumber = inputList[0].toLong()
        if (inputList.size < 2)
            return firstNumber
        return firstNumber.plus(inputList[1].toLong())
    }
}
