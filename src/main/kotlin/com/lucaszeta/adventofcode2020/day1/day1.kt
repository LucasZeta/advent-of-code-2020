package com.lucaszeta.adventofcode2020.day1

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun findPair(
    input: List<Int>,
    sumGoal: Int
): Pair<Int, Int> {
    for (index in 0 until input.size - 1) {
        search@ for (secondIndex in (index + 1) until input.size) {
            val operand1 = input[index]
            val operand2 = input[secondIndex]
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
    for (index in 0 until input.size - 2) {
        for (secondIndex in (index + 1) until input.size - 1) {
            search@ for (thirdIndex in (secondIndex + 1) until input.size) {
                val operand1 = input[index]
                val operand2 = input[secondIndex]
                val operand3 = input[thirdIndex]
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
    val input = getResourceAsText("/day1/expense-report.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
        .sorted()

    val pair = findPair(input, 2020)
    val triple = findTriple(input, 2020)

    println("Day 1 part 1: %d".format(pair.first * pair.second))
    println("Day 1 part 2: %d".format(triple.first * triple.second * triple.third))
}
