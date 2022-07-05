package com.calculator.com.calculator

class Calculator {
    fun calculate(s: String): Int {
        if (',' in s)
            return s.split(',').sumOf { it.toInt() }
        if (s != "")
            return s.toInt()
        return 0
    }

}
