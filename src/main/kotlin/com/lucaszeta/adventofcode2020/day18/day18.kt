package com.lucaszeta.adventofcode2020.day18

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val expressions = getResourceAsText("/day18/homework.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val fromLeftToRightResult = expressions
        .map(::evaluateExpression)
        .reduce(Long::plus)

    println("Sum of resulting values considering left > right: $fromLeftToRightResult")

    val sumOverMultiplicationResult = expressions
        .map(::evaluateAdvancedMathExpression)
        .reduce(Long::plus)

    println("Sum of resulting values considering + > *: $sumOverMultiplicationResult")
}
