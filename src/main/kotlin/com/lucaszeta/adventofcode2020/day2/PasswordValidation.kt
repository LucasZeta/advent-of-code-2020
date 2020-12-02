package com.lucaszeta.adventofcode2020.day2

import java.lang.IllegalArgumentException

val VALIDATION_REGEX = "([0-9].*)-([0-9].*) ([a-z]): (.*)".toRegex()

class PasswordValidation(
    input: String
) {

    val minLength: Int
    val maxLength: Int
    val char: String
    val password: String

    init {
        val result = VALIDATION_REGEX.matchEntire(input)

        if (!result?.groupValues.isNullOrEmpty()) {
            val groupValues = result?.groupValues!!

            minLength = groupValues[1].toInt()
            maxLength = groupValues[2].toInt()
            char = groupValues[3]
            password = groupValues[4]
        } else {
            throw IllegalArgumentException("Invalid input")
        }
    }
}
