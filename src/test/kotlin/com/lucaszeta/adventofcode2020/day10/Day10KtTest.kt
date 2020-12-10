package com.lucaszeta.adventofcode2020.day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10KtTest {

    @Test
    fun `Should find device adapter joltage`() {
        val input = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

        assertEquals(22, findDeviceAdapterJoltage(input))
    }

    @Test
    fun `Should map joltage differences`() {
        val input = listOf(0, 16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4, 22)
        val expectedOutput = mapOf(
            1 to 7,
            3 to 5
        )

        assertEquals(expectedOutput, input.findJoltageGroupDifferences())

        val input2 = listOf(
            0, 28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19,
            38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3, 52
        )

        val expectedOutput2 = mapOf(
            1 to 22,
            3 to 10
        )
        assertEquals(expectedOutput2, input2.findJoltageGroupDifferences())
    }

    @Test
    fun `Should count possible arrangements`() {
        val input = listOf(0, 16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4, 22)

        assertEquals(8, input.findArrangements())

        val input2 = listOf(
            0, 28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19,
            38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3, 52
        )

        assertEquals(19208, input2.findArrangements())
    }

    @Test
    fun `Should calculate arrangements for groups of one`() {
        assertEquals(1, calculateArrangementsForSize(1))
        assertEquals(2, calculateArrangementsForSize(2))
        assertEquals(4, calculateArrangementsForSize(3))
        assertEquals(7, calculateArrangementsForSize(4))
    }
}
