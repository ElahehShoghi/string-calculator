package com.calculator.exception

class InvalidDelimiterException(expectedSeparator: String, invalidSeparator: String, position: Int) :
    Exception("'$expectedSeparator' expected but '$invalidSeparator' found at position $position.")