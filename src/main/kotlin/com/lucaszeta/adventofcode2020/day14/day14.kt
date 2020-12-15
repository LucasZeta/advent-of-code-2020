package com.lucaszeta.adventofcode2020.day14

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlin.math.pow

fun main() {
    val input = getResourceAsText("/day14/initialization-program.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    listOf(
        ::processInstructions to "old decoder",
        ::processInstructionsV2 to "v2 decoder"
    ).forEach { (method, label) ->
        val resultMap = method.invoke(input)
        val sumOfValuesInMemory = resultMap.map { it.value }.reduce(Long::plus)

        println("Sum of all values left ($label): $sumOfValuesInMemory")
    }
}

fun processInstructions(input: List<String>): MutableMap<Long, Long> {
    var bitmask = listOf<String>()
    val resultMap = mutableMapOf<Long, Long>()

    for (instruction in input) {
        extractMask(instruction)?.let {
            bitmask = it
        }

        extractMemory(instruction)?.let { (address, value) ->
            val maskApplied = applyMask(bitmask, value)

            resultMap[address.toLong()] = maskApplied
        }
    }

    return resultMap
}

fun processInstructionsV2(input: List<String>): MutableMap<Long, Long> {
    var bitmask = listOf<String>()
    val resultMap = mutableMapOf<Long, Long>()

    for (instruction in input) {
        extractMask(instruction)?.let {
            bitmask = it
        }

        extractMemory(instruction)?.let { (address, value) ->
            fetchAddressList(bitmask, address).forEach {
                resultMap[it] = value.fromBinaryToLong()
            }
        }
    }

    return resultMap
}

fun applyMask(bitmask: List<String>, value: List<String>): Long {
    val valueSameSizeAsMask = value.addLeadingZeros(bitmask.size)

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

fun fetchAddressList(bitmask: List<String>, originAddress: Int): List<Long> {
    val addresses = mutableListOf<Long>()
    val binaryAddress = Integer.toBinaryString(originAddress)
        .chunked(1)
        .addLeadingZeros(bitmask.size)

    val indicesToReplace = mutableListOf<Int>()
    val maskApplied = mutableListOf<String>()

    bitmask.zip(binaryAddress).forEachIndexed { index, (mask, address) ->
        val newBit = when (mask) {
            "0" -> address
            "1" -> mask
            else -> {
                indicesToReplace.add(index)
                mask
            }
        }

        maskApplied.add(newBit)
    }

    val possibilities = 2.0.pow(indicesToReplace.size).toInt()

    for (number in 0 until possibilities) {
        val bits = Integer.toBinaryString(number).chunked(1).addLeadingZeros(indicesToReplace.size)
        val temp = maskApplied

        bits.forEachIndexed { index, char ->
            temp[indicesToReplace[index]] = char
        }

        addresses.add(temp.toList().fromBinaryToLong())
    }

    return addresses
}

private fun List<String>.addLeadingZeros(maximumSize: Int): List<String> {
    return toMutableList()
        .apply {
            while (size < maximumSize) {
                add(0, "0")
            }
        }
        .toList()
}

private fun List<String>.fromBinaryToLong(): Long {
    return map { it.toLong() }
        .reversed()
        .reduceIndexed { index, acc, bit ->
            acc + bit * 2.0.pow(index).toLong()
        }
}
