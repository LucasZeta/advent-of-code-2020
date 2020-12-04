package com.lucaszeta.adventofcode2020.day4

fun parseData(input: String) = input
    .replace("([a-z0-9])\\n([a-z0-9])".toRegex()) {
        "%s %s".format(
            it.groupValues[1],
            it.groupValues[2]
        )
    }
    .replace("\n\n", "\n")
    .split("\n")
