package com.lucaszeta.adventofcode2020.day6

fun parseData(input: String) = input
    .replace("([a-z])\\n".toRegex()) {
        it.groupValues[1]
    }
    .split("\n")
    .filter { it.isNotEmpty() }
