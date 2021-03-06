package com.lucaszeta.adventofcode2020.day02

import java.lang.IllegalArgumentException

class PasswordValidation(
    input: String
) {

    val firstSlot: Int
    val secondSlot: Int
    val char: Char
    val password: String

    init {
        val result = VALIDATION_REGEX.matchEntire(input)

        if (!result?.groupValues.isNullOrEmpty()) {
            val groupValues = result?.groupValues!!

            firstSlot = groupValues[FIRST_SLOT].toInt()
            secondSlot = groupValues[SECOND_SLOT].toInt()
            char = groupValues[VERIFICATION_CHAR].single()
            password = groupValues[PASSWORD]
        } else {
            throw IllegalArgumentException("Invalid input")
        }
    }

    fun isSledRentalValid(): Boolean {
        val charCount = password.toCharArray().count { it == char }

        return charCount in firstSlot..secondSlot
    }

    fun isTobogganValid(): Boolean {
        val verificationString = "${password[firstSlot - 1]}${password[secondSlot - 1]}"

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
