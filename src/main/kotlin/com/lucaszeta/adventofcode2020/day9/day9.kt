package com.lucaszeta.adventofcode2020.day9

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import java.lang.IllegalArgumentException

fun main() {
    val input = getResourceAsText("/day9/xmas-number-series.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toLong() }

    println(findNumberNotSumOfPrevious(input, 25))
}

fun findNumbersThatSumToTarget(numbers: List<Long>, targetNumber: Long): List<Long> {
    for (i in 0 until numbers.size - 1) {
        for (j in (i + 1) until numbers.size) {
            val numbersInRange = numbers.slice(i..j)

            if (numbersInRange.reduce(Long::plus) == targetNumber) {
                return numbersInRange
            }
        }
    }

    throw IllegalArgumentException("No numbers in list sum to $targetNumber")
}

fun calculateXmasEncryptionWeakness(numberList: List<Long>) =
    (numberList.minOrNull() ?: 0) +
    (numberList.maxOrNull() ?: 0)

fun findNumberNotSumOfPrevious(numbers: List<Long>, preamble: Int): Long {
    for (index in preamble until numbers.size) {
        val previousNumbersGroup = numbers.slice((index - preamble) until index)
        val currentNumber = numbers[index]

        val isResultOfSumOfPrevious = previousNumbersGroup.any { previousNumber ->
            previousNumbersGroup
                .filter { it != previousNumber }
                .contains(currentNumber - previousNumber)
        }

        if (!isResultOfSumOfPrevious) {
            return currentNumber
        }
    }

    throw IllegalArgumentException("All numbers are sum of the previous $preamble")
}
