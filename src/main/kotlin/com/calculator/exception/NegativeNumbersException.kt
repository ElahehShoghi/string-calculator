package com.calculator.exception

class NegativeNumbersException(negativeNumber: List<String>) : Exception("Negative number(s) not allowed: ${negativeNumber.joinToString()}") {

}
