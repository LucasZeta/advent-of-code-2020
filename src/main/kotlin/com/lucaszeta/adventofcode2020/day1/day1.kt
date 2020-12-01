package com.lucaszeta.adventofcode2020.day1

fun findPair(
    input: List<Int>,
    sumGoal: Int
): Pair<Int, Int> {
    for ((index, operand1) in input.dropLast(1).withIndex()) {
        val remainingNumbers = input.filterIndexed { secondIndex, _ -> secondIndex > index }

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
        val secondGroup = input.filterIndexed { secondIndex, _ -> secondIndex > index }

        for ((index2, operand2) in secondGroup.dropLast(1).withIndex()) {
            val remainingNumbers = input.filterIndexed { thirdIndex, _ -> thirdIndex > index2 }

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
    val operands = findPair(input, 2020)

    println(operands.first * operands.second)
}
