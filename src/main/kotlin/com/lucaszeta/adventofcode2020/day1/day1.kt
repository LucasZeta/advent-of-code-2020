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

fun main() {
    val operands = findPair(input, 2020)

    println(operands.first * operands.second)
}
