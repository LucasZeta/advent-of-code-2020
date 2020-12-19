package com.lucaszeta.adventofcode2020.day18

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
