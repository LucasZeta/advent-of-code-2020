package com.lucaszeta.adventofcode2020.day1

fun findPair(
    input: List<Int>,
    sumGoal: Int
): Pair<Int, Int> {
    for (index in 0 until input.size - 1) {
        for (secondIndex in (index + 1) until input.size) {
            val operand1 = input[index]
            val operand2 = input[secondIndex]

            if (operand1 + operand2 == sumGoal) {
                return operand1 to operand2
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
            for (thirdIndex in (secondIndex + 1) until input.size) {
                val operand1 = input[index]
                val operand2 = input[secondIndex]
                val operand3 = input[thirdIndex]

                if (operand1 + operand2 + operand3 == sumGoal) {
                    return Triple(operand1, operand2, operand3)
                }
            }
        }
    }

    throw IllegalArgumentException("There are no elements in this input that sum to %d".format(sumGoal))
}

fun main() {
    val pair = findPair(input, 2020)
    val triple = findTriple(input, 2020)

    println("Day 1 part 1: %d".format(pair.first * pair.second))
    println("Day 1 part 2: %d".format(triple.first * triple.second * triple.third))
}
