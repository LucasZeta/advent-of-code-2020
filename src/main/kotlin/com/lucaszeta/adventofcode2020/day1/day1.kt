package com.lucaszeta.adventofcode2020.day1

private fun List<Int>.listWithRemainingNumbers(currentIndex: Int) =
    filterIndexed { index, _ -> index > currentIndex }

fun findPair(
    input: List<Int>,
    sumGoal: Int
): Pair<Int, Int> {
    for ((index, operand1) in input.dropLast(1).withIndex()) {
        val remainingNumbers = input.listWithRemainingNumbers(index)

        for (operand2 in remainingNumbers) {
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
    for ((index, operand1) in input.dropLast(1).withIndex()) {
        val secondGroup = input.listWithRemainingNumbers(index)

        for ((secondIndex, operand2) in secondGroup.dropLast(1).withIndex()) {
            val remainingNumbers = input.listWithRemainingNumbers(secondIndex)

            for (operand3 in remainingNumbers) {
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
