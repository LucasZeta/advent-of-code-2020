package com.lucaszeta.adventofcode2020.day14

import kotlin.math.pow

fun applyMask(bitmask: List<String>, value: List<String>): Long {
    val valueSameSizeAsMask = value.toMutableList()
        .apply {
            while (size < bitmask.size) {
                add(0, "0")
            }
        }
        .toList()

    val binaryString = mutableListOf<String>()
        .apply {
            bitmask.zip(valueSameSizeAsMask).forEach { (mask, value) ->
                add(if (mask != "X") mask else value)
            }
        }
        .toList()

    return binaryString.fromBinaryToLong()
}

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

private fun List<String>.fromBinaryToLong(): Long {
    return map { it.toLong() }
        .reversed()
        .reduceIndexed { index, acc, bit ->
            acc + bit * 2.0.pow(index).toLong()
        }
}
