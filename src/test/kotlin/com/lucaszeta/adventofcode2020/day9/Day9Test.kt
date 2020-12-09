package com.lucaszeta.adventofcode2020.day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class Day9Test {

    @Test
    fun `Should find number not product of sum of previous numbers`() {
        val input = listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
            .map { it.toLong() }

        assertEquals(127, findNumberNotSumOfPrevious(input, 5))
    }

    @Test
    fun `Should throw exception when all numbers are product of sum of previous numbers`() {
        val input = listOf(0, 0, 0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
            .map { it.toLong() }

        assertThrows<IllegalArgumentException> {
            findNumberNotSumOfPrevious(input, 5)
        }
    }

    @Test
    fun `Should find adjacent set of numbers that sum to target`() {
        listOf(
            listOf(35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576),
            listOf(15, 25, 47, 40, 35, 20, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576),
            listOf(35, 20, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576, 15, 25, 47, 40)
        ).forEach { numbers ->
            assertEquals(
                listOf(15L, 25L, 47L, 40L),
                findNumbersThatSumToTarget(numbers.map { it.toLong() }, 127)
            )
        }
    }

    @Test
    fun `Should throw exception when not finding adjacent numbers that sum to target`() {
        val input = listOf(35, 20, 15, 25, 47, 43, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)
            .map { it.toLong() }

        assertThrows<IllegalArgumentException> {
            findNumbersThatSumToTarget(input, 127)
        }
    }

    @Test
    fun `Should find encryption weakness`() {
        val input = listOf(15L, 25L, 47L, 40L)

        assertEquals(62, calculateXmasEncryptionWeakness(input))
    }
}
