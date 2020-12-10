package com.lucaszeta.adventofcode2020.day10

fun List<Int>.findJoltageGroupDifferences(): Map<Int, Int> {
    val sortedValues = sorted()

    return sortedValues
        .mapIndexed { index, joltage ->
            if (index > 0) {
                joltage - sortedValues[index - 1]
            } else 0
        }
        .filter { it != 0 }
        .groupBy { it }
        .mapValues {
            it.value.size
        }
}

fun findDeviceAdapterJoltage(bagAdapterJoltages: List<Int>) =
    (bagAdapterJoltages.maxOrNull() ?: 0) + 3

