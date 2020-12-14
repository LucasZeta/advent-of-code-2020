package com.lucaszeta.adventofcode2020.day14

fun extractMemory(instruction: String): Pair<Int, List<String>>? {
    val memoryResult = "mem\\[([0-9]*)] = ([0-9]*)".toRegex().matchEntire(instruction)

    return memoryResult?.let {
        val address = it.groupValues[1].toInt()
        val value = Integer.toBinaryString(it.groupValues[2].toInt())
            .chunked(1)

        address to value
    }
}

fun extractMask(instruction: String): List<String>? {
    val maskResult = "mask = ([01X]*)".toRegex().matchEntire(instruction)

    return maskResult?.let {
        it.groupValues[1].chunked(1)
    }
}
