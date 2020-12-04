package com.lucaszeta.adventofcode2020.day4

import java.lang.IllegalArgumentException

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

    HEIGHT("hgt", {
        val result = "(\\d+)(cm|in)".toRegex().matchEntire(it)

        if (!result?.groupValues.isNullOrEmpty()) {
            val groupValues = result?.groupValues!!
            val number = groupValues[1].toInt()

            when (groupValues[2]) {
                "cm" -> number in 150..193
                else -> number in 59..76
            }
        } else {
            false
        }
    }),

    HAIR_COLOR("hcl", {
        "#[0-9a-f]{6}".toRegex().matches(it)
    }),

    EYE_COLOR("ecl", {
        "(amb|blu|brn|gry|grn|hzl|oth)".toRegex().matches(it)
    }),

    PASSPORT_ID("pid", {
        "[0-9]{9}".toRegex().matches(it)
    }),

    COUNTRY_ID("cid", {
        true
    });

    companion object {

        fun fromKey(key: String): PassportField {
            return values()
                .find { it.key == key }
                ?: throw IllegalArgumentException("Invalid passport field key")
        }
    }
}
