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

    val numberIn30000000thIndex = findNthNumber(numbers, 30000000)
    println("30000000th number spoken: $numberIn30000000thIndex")
}

fun findNthNumber(numbers: List<Int>, listSize: Int): Int {
    val mutableMap = mutableMapOf<Int, MutableList<Int>>()
    numbers.forEachIndexed { index, i ->
        if (mutableMap.containsKey(i)) {
            mutableMap[i]?.add(index + 1)
        } else {
            mutableMap[i] = mutableListOf(index + 1)
        }
    }

    var currentNumber = numbers.last()

    for (index in (numbers.size + 1)..listSize) {
        if (mutableMap.containsKey(currentNumber) &&
            mutableMap.getValue(currentNumber).size > 1
        ) {

            if (mutableMap.getValue(currentNumber).size > 2) {
                mutableMap.getValue(currentNumber).removeAt(0)
            }

            val indexes = mutableMap.getValue(currentNumber)

            currentNumber = indexes.last() - indexes.first()
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
