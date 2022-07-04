package com.tdd

class StringCalculator {

    fun calculate(inputs: String): Long {
        return java.lang.Long.valueOf(inputs.toList()[0].toString())
            .plus(java.lang.Long.valueOf(inputs.toList()[2].toString()))
    }
}
