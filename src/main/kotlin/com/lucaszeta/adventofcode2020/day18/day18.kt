package com.lucaszeta.adventofcode2020.day18

fun evaluateExpression(expression: String): Int {
    var operand1 = 0
    var operand2 = 0
    var operator: ((Int, Int) -> Int)? = null

    val numbersPattern = "(\\d+)".toRegex()

    expression.chunked(1).forEachIndexed { index, instruction ->
        var newDigit = 0

        when (instruction) {
            "+" -> operator = Int::plus
            "*" -> operator = Int::times
            "(" -> newDigit = evaluateExpression(expression.drop(index + 1))
            ")" -> return operand1
            else -> {
                if (numbersPattern.matches(instruction)) {
                    newDigit = instruction.toInt()
                }
            }
        }

        if (newDigit > 0) {
            if (operand1 == 0) {
                operand1 = instruction.toInt()
            } else {
                operand2 = instruction.toInt()
            }
        }

        if (operand1 > 0 && operator != null && operand2 > 0) {
            operator?.let {
                operand1 = it.invoke(operand1, operand2)
            }

            operator = null
            operand2 = 0
        }
    }

    return operand1
}
