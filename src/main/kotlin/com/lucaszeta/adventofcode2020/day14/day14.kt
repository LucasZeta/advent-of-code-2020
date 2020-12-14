package com.lucaszeta.adventofcode2020.day14

fun extractMask(instruction: String): List<String>? {
    val maskResult = "mask = ([01X]*)".toRegex().matchEntire(instruction)

    return maskResult?.let {
        it.groupValues[1].chunked(1)
    }
}
