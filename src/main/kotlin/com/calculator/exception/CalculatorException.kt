package com.calculator.exception

class CalculatorException(vararg exceptions: Throwable) :
    Exception(exceptions.map { it.message }.joinToString("\n"))
