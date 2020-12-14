package com.lucaszeta.adventofcode2020.day14

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlin.math.pow

fun main() {
    val input = getResourceAsText("/day14/initialization-program.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val resultMap = processInstructions(input)
    val sumOfValuesInMemory = resultMap.map { it.value }.reduce(Long::plus)

    println("Sum of all values left in memory: $sumOfValuesInMemory")
}

fun processInstructions(input: List<String>): MutableMap<Int, Long> {
    var bitmask = listOf<String>()
    val resultMap = mutableMapOf<Int, Long>()

    for (instruction in input) {
        extractMask(instruction)?.let {
            bitmask = it
        }

        extractMemory(instruction)?.let { (address, value) ->
            val maskApplied = applyMask(bitmask, value)

            resultMap[address] = maskApplied
        }
    }

    return resultMap
}

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
