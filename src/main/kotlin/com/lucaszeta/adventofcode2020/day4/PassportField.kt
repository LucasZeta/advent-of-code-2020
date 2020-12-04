package com.lucaszeta.adventofcode2020.day4

enum class PassportField(
    val key: String,
    val isValid: (String) -> Boolean
) {
    BIRTH_YEAR("byr", {
        it.toInt() in 1920..2002
    }),

    ISSUE_YEAR("iyr", {
        it.toInt() in 2010..2020
    }),

    EXPIRATION_YEAR("eyr", {
        it.toInt() in 2020..2030
    })
}
