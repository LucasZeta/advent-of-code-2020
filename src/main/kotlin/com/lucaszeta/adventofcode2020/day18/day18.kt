package com.lucaszeta.adventofcode2020.day18

fun evaluateExpression(expression: String): Int {
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

    return line.toInt()
}

private fun calculateMatchResult(matchResult: MatchResult): Int {
    val (_, operand1, operatorKey, operand2) = matchResult.groupValues

    val operation: (Int, Int) -> Int = if (operatorKey == "+") Int::plus else Int::times

    return operation.invoke(
        operand1.toInt(),
        operand2.toInt()
    )
}
