package com.lucaszeta.adventofcode2020.day10

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlin.math.pow

fun main() {
    val bagAdapterJoltages = getResourceAsText("/day10/adapters-output-joltage.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

    val chargingOutletJoltage = 0
    val deviceJoltage = findDeviceAdapterJoltage(bagAdapterJoltages)

    val connections = bagAdapterJoltages
        .toMutableList()
        .apply {
            add(chargingOutletJoltage)
            add(deviceJoltage)
        }
        .toList()

    val differencesMap = connections.findJoltageGroupDifferences()
    val possibleArrangements = connections.findArrangements()

    println(
        "Product of 1-jolt difference by 3-jolt difference: %d".format(
            differencesMap.getValue(1) * differencesMap.getValue(3)
        )
    )
    println("Possible adapter arrangements: $possibleArrangements")
}

fun List<Int>.findJoltageGroupDifferences(): Map<Int, Int> {
    return findDifferences(this)
        .groupBy { it }
        .mapValues {
            it.value.size
        }
}

fun List<Int>.findArrangements(): Long {
    val differences = findDifferences(this).joinToString("")
    val sequencesOfOne = "(1+)".toRegex().findAll(differences)

    return sequencesOfOne.map {
        calculateArrangementsForSize(it.groupValues[1].length).toLong()
    }.reduce(Long::times)
}

fun calculateArrangementsForSize(size: Int): Int {
    var result = 2.0.pow(size - 1)

    if (size > 3) {
        result -= 2.0.pow(size - 4)
    }

    return result.toInt()
}

fun findDifferences(joltageList: List<Int>): List<Int> {
    val sortedValues = joltageList.sorted()

    return sortedValues
        .mapIndexed { index, joltage ->
            if (index > 0) {
                joltage - sortedValues[index - 1]
            } else 0
        }
        .filter { it != 0 }
}

fun findDeviceAdapterJoltage(bagAdapterJoltages: List<Int>) =
    (bagAdapterJoltages.maxOrNull() ?: 0) + 3

