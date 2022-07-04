package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        if (inputs.trim() == "")
            return 0
        if (inputs.toList().size < 3)
            return java.lang.Long.valueOf(inputs.toList()[0].toString())
        return java.lang.Long.valueOf(inputs.toList()[0].toString())
            .plus(java.lang.Long.valueOf(inputs.toList()[2].toString()))
    }
}
