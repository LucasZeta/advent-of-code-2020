package com.lucaszeta.adventofcode2020.day18

fun evaluateExpression(expression: String): Int {
    var operand1: Int? = null
    var operand2: Int? = null
    var operator: ((Int, Int) -> Int)? = null

    val numbersPattern = "(\\d+)".toRegex()

    expression.chunked(1).forEachIndexed { index, instruction ->
        var newDigit = 0

        when (instruction) {
            "+" -> operator = Int::plus
            "*" -> operator = Int::times
            "(" -> newDigit = evaluateExpression(expression.drop(index + 1))
            ")" -> return operand1 ?: 0
            else -> {
                if (numbersPattern.matches(instruction)) {
                    newDigit = instruction.toInt()
                }
            }
        }

        if (newDigit > 0) {
            if (operand1 == null) {
                operand1 = instruction.toInt()
            } else {
                operand2 = instruction.toInt()
            }
        }

        if (operand1 != null && operator != null && operand2 != null) {
            val a = operand1!!
            val b = operand2!!
            val operation = operator!!

            operand1 = operation(a, b)

            operator = null
            operand2 = null
        }
    }

    return operand1 ?: 0
}
