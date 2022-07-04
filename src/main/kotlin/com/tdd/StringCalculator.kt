package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        val firstNumber = getValueFromListByIndex(inputs.toList(), 0)
        if (inputs.toList().size < 3)
            return firstNumber
        return firstNumber.plus(getValueFromListByIndex(inputs.toList(), 2))
    }

    private fun getValueFromListByIndex(list: List<Char>, index: Int): Long {
        return java.lang.Long.valueOf(list[index].toString())
    }
}
