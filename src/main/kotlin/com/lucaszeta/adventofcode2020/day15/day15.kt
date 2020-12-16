package com.lucaszeta.adventofcode2020.day15

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val numbers = getResourceAsText("/day15/starting-numbers.txt")
        .split("\n")
        .first { it.isNotEmpty() }
        .split(",")
        .map { it.toInt() }

    val numberIn2020thIndex = findNthNumber(numbers, 2020)

    println("2020th number spoken: $numberIn2020thIndex")
}

fun findNthNumber(numbers: List<Int>, listSize: Int): Int {
    val mutableMap = mutableMapOf<Int, MutableList<Int>>()
    numbers.forEachIndexed { index, i ->
        mutableMap[i] = mutableListOf(index + 1)
    }

    var currentNumber = numbers.last()

    for (index in (numbers.size + 1)..listSize) {
        if (mutableMap.containsKey(currentNumber) &&
                mutableMap.getValue(currentNumber).size > 1) {
            val indexes = mutableMap.getValue(currentNumber)

            currentNumber = indexes[indexes.size - 1] - indexes[indexes.size - 2]
        } else {
            currentNumber = 0
        }

        if (mutableMap.containsKey(currentNumber)) {
            mutableMap[currentNumber]?.add(index)
        } else {
            mutableMap[currentNumber] = mutableListOf(index)
        }
    }

    return currentNumber
}
