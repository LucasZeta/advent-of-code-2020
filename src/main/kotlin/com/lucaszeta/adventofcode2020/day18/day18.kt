package com.lucaszeta.adventofcode2020.day18

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val expressions = getResourceAsText("/day18/homework.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val sum = expressions
        .map(::evaluateExpression)
        .reduce(Long::plus)

    println("Sum of resulting values: $sum")
}

fun evaluateExpression(expression: String): Long {
    var line = "($expression)"

    val closedEvaluationPattern = "\\((\\d+) ([+*]) (\\d+)\\)".toRegex()
    val openEvaluationPattern = "\\((\\d+) ([+*]) (\\d+)".toRegex()

    while (closedEvaluationPattern.containsMatchIn(line) ||
        (openEvaluationPattern.containsMatchIn(line))) {

        while (closedEvaluationPattern.containsMatchIn(line)) {
            line = closedEvaluationPattern.replace(line) {
                val innerResult = calculateMatchResult(it)

                return@replace "$innerResult"
            }
        }

        line = openEvaluationPattern.replace(line) {
            val innerResult = calculateMatchResult(it)

            return@replace "($innerResult"
        }
    }

    return line.toLong()
}

private fun calculateMatchResult(matchResult: MatchResult): Long {
    val (_, operand1, operatorKey, operand2) = matchResult.groupValues

    val operation: (Long, Long) -> Long = if (operatorKey == "+") Long::plus else Long::times

    return operation.invoke(
        operand1.toLong(),
        operand2.toLong()
    )
}
