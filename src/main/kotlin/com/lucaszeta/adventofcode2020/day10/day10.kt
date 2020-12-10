package com.lucaszeta.adventofcode2020.day10

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val bagAdapterJoltages = getResourceAsText("/day10/adapters-output-joltage.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

    val chargingOutletJoltage = 0
    val deviceJoltage = findDeviceAdapterJoltage(bagAdapterJoltages)

    val differencesMap = bagAdapterJoltages
        .toMutableList()
        .apply {
            add(chargingOutletJoltage)
            add(deviceJoltage)
        }
        .toList()
        .findJoltageGroupDifferences()

    println(
        "Product of 1-jolt difference by 3-jolt difference: %d".format(
            differencesMap.getValue(1) * differencesMap.getValue(3)
        )
    )
}

fun List<Int>.findJoltageGroupDifferences(): Map<Int, Int> {
    return findDifferences(this)
        .groupBy { it }
        .mapValues {
            it.value.size
        }
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

