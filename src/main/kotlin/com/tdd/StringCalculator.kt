package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        return java.lang.Long.valueOf(inputs.toList()[0].toString())
            .plus(java.lang.Long.valueOf(inputs.toList()[2].toString()))
    }
}
