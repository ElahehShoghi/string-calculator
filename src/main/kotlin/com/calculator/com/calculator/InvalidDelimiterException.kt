package com.calculator.com.calculator

class InvalidDelimiterException(expectedSeparator: String, invalidSeparator: String, position: Int) :
    Exception("'$expectedSeparator' expected but '$invalidSeparator' found at position $position.")