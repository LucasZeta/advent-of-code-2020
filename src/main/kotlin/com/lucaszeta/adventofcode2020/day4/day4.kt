package com.lucaszeta.adventofcode2020.day4

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun parseData(input: String) = input
    .replace("([a-z0-9])\\n([a-z0-9])".toRegex()) {
        "%s %s".format(
            it.groupValues[1],
            it.groupValues[2]
        )
    }
    .replace("\n\n", "\n")
    .split("\n")

fun countValidPassports(input: List<String>) =
    input.map(::Passport).count { it.isValid() }

fun main() {
    val input = parseData(getResourceAsText("/day4/passport-batch-file.txt"))

    println("Valid passports: %d".format(countValidPassports(input)))
}
