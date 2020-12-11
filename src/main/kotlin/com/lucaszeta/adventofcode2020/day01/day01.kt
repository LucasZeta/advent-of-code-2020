package com.lucaszeta.adventofcode2020.day01

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun findPair(
    input: List<Int>,
    sumGoal: Int
): Pair<Int, Int> {
    val numbers = input.sorted()

    for (index in 0 until numbers.size - 1) {
        search@ for (secondIndex in (index + 1) until numbers.size) {
            val operand1 = numbers[index]
            val operand2 = numbers[secondIndex]
            val sum = operand1 + operand2

            when {
                sum == sumGoal -> return operand1 to operand2
                sum > sumGoal -> break@search
            }
        }
    }

    throw IllegalArgumentException("There are no elements in this input that sum to %d".format(sumGoal))
}

fun findTriple(
    input: List<Int>,
    sumGoal: Int
): Triple<Int, Int, Int> {
    val numbers = input.sorted()

    for (index in 0 until numbers.size - 2) {
        for (secondIndex in (index + 1) until numbers.size - 1) {
            search@ for (thirdIndex in (secondIndex + 1) until numbers.size) {
                val operand1 = numbers[index]
                val operand2 = numbers[secondIndex]
                val operand3 = numbers[thirdIndex]
                val sum = operand1 + operand2 + operand3

                when {
                    sum == sumGoal -> return Triple(operand1, operand2, operand3)
                    sum > sumGoal -> break@search
                }
            }
        }
    }

    throw IllegalArgumentException("There are no elements in this input that sum to %d".format(sumGoal))
}

fun main() {
    val input = getResourceAsText("/day01/expense-report.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

    val pair = findPair(input, 2020)
    val triple = findTriple(input, 2020)

    println("Day 1 part 1: %d".format(pair.first * pair.second))
    println("Day 1 part 2: %d".format(triple.first * triple.second * triple.third))
}
