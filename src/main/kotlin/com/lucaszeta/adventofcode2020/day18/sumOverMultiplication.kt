package com.lucaszeta.adventofcode2020.day18

fun evaluateAdvancedMathExpression(expression: String): Long {
    var line = "($expression)"

    val operatorPrecedence = listOf(
        SUM_IN_PARENTHESIS to sum,
        SUM to sum,
        MULTIPLE_MULTIPLICATION to multiplication,
        MULTIPLICATION_IN_PARENTHESIS to multiplication,
        MULTIPLICATION to multiplication
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

private val SUM_IN_PARENTHESIS = "\\((\\d+) \\+ (\\d+)\\)".toRegex()
private val SUM = "(\\d+) \\+ (\\d+)".toRegex()
private val MULTIPLE_MULTIPLICATION = "\\((\\d+) \\* (\\d+)( [^()]+)\\)".toRegex()
private val MULTIPLICATION_IN_PARENTHESIS = "\\((\\d+) \\* (\\d+)\\)".toRegex()
private val MULTIPLICATION = "(\\d+) \\* (\\d+)".toRegex()

private val sum: (MatchResult) -> CharSequence = {
    doOperationAndReturnString(it, Long::plus)
}

private val multiplication: (MatchResult) -> CharSequence = {
    doOperationAndReturnString(it, Long::times)
}

private val doOperationAndReturnString: (
    MatchResult,
    (Long, Long) -> Long
) -> CharSequence = { matchResult, operation ->
    val (_, operand1, operand2) = matchResult.groupValues
    val restOfExpression = if (matchResult.groupValues.size == 4) {
        matchResult.groupValues.last()
    } else ""

    val result = operation(operand1.toLong(), operand2.toLong())

    if (restOfExpression.isNotEmpty()) {
        "($result$restOfExpression)"
    } else {
        "$result"
    }
}
