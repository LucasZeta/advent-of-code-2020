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

    while (
        closedEvaluationPattern.containsMatchIn(line) ||
        openEvaluationPattern.containsMatchIn(line)
    ) {

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

fun evaluateAdvancedMathExpression(expression: String): Long {
    var line = "($expression)"

    val doOperationAndReturnString: (
        MatchResult,
        (Long, Long) -> Long
    ) -> CharSequence = { matchResult, operation ->
        val (_, operand1, operand2) = matchResult.groupValues

        val result = operation(operand1.toLong(), operand2.toLong())

        "$result"
    }

    val sum: (MatchResult) -> CharSequence = {
        doOperationAndReturnString(it, Long::plus)
    }

    val multiplication: (MatchResult) -> CharSequence = {
        doOperationAndReturnString(it, Long::times)
    }

    val operatorPrecedence = listOf(
        "\\((\\d+) \\+ (\\d+)\\)".toRegex() to sum,
        "(\\d+) \\+ (\\d+)".toRegex() to sum,
        "\\((\\d+) \\* (\\d+)\\)".toRegex() to multiplication,
        "(\\d+) \\* (\\d+)".toRegex() to multiplication
    )

    var didAnyOperation: Boolean

    do {
        didAnyOperation = false

        for (precedence in operatorPrecedence) {
            val (pattern, operation) = precedence

            if (pattern.containsMatchIn(line)) {
                line = pattern.replace(line, operation)
                didAnyOperation = true
                break
            }
        }
    } while (didAnyOperation)

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
