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
    }),

    HAIR_COLOR("hcl", {
        "^\\#[0-9a-f]{6}\$".toRegex().matches(it)
    }),

    EYE_COLOR("ecl", {
        "(amb|blu|brn|gry|grn|hzl|oth)".toRegex().matches(it)
    });
}
