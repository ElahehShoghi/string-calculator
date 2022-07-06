package com.calculator

class NegativeNumberFinder {

    fun findNegativeNumbers(tokens: List<String>) =
        tokens.flatMap { it.replace(Regex("[^1-9-]+"), " ").split(" ") }
            .filter { "-" in it }
            .takeUnless { it.isEmpty() }
}