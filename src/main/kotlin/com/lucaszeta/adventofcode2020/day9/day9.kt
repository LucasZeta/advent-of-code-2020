package com.lucaszeta.adventofcode2020.day9

import java.lang.IllegalArgumentException

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
