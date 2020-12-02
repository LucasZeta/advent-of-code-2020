package com.lucaszeta.adventofcode2020.day2

import java.lang.IllegalArgumentException

class PasswordValidation(
    input: String
) {

    val minLength: Int
    val maxLength: Int
    val char: Char
    val password: String

    init {
        val result = VALIDATION_REGEX.matchEntire(input)

        if (!result?.groupValues.isNullOrEmpty()) {
            val groupValues = result?.groupValues!!

            minLength = groupValues[FIRST_SLOT].toInt()
            maxLength = groupValues[SECOND_SLOT].toInt()
            char = groupValues[VERIFICATION_CHAR].single()
            password = groupValues[PASSWORD]
        } else {
            throw IllegalArgumentException("Invalid input")
        }
    }

    fun isSledRentalValid(): Boolean {
        val charCount = password.toCharArray().count { it == char }

        return charCount in minLength..maxLength
    }

    fun isTobogganValid(): Boolean {
        val verificationString = "${password[minLength-1]}${password[maxLength-1]}"

        return verificationString.toCharArray().count { it == char } == 1
    }

    companion object {
        const val FIRST_SLOT = 1
        const val SECOND_SLOT = 2
        const val VERIFICATION_CHAR = 3
        const val PASSWORD = 4

        val VALIDATION_REGEX = "([0-9].*)-([0-9].*) ([a-z]): (.*)".toRegex()
    }
}
