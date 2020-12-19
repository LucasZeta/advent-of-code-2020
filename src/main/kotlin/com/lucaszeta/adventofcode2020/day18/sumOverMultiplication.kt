package com.lucaszeta.adventofcode2020.day18

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
