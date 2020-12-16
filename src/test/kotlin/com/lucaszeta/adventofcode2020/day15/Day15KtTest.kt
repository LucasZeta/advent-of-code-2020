package com.lucaszeta.adventofcode2020.day15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day15KtTest {

    @Test
    fun `Should iterate until nth number is found`() {
        listOf(
            listOf(1, 3, 2) to 1,
            listOf(2, 1, 3) to 10,
            listOf(1, 2, 3) to 27,
            listOf(2, 3, 1) to 78,
            listOf(3, 2, 1) to 438,
            listOf(3, 1, 2) to 1836
        ).forEach { (input, expectedOutput) ->
            assertEquals(
                expectedOutput,
                findNthNumber(input.toMutableList(), 2020)
            )
        }
    }

    @Test
    fun `Should iterate until a big nth number is found`() {
        listOf(
            listOf(1, 3, 2) to 0,
            listOf(2, 1, 3) to 2419,
            listOf(1, 2, 3) to 186,
            listOf(2, 3, 1) to 10,
            listOf(3, 2, 1) to 1437890,
            listOf(3, 1, 2) to 0
        ).forEach { (input, expectedOutput) ->
            assertEquals(
                expectedOutput,
                findNthNumber(input, 3000000)
            )
        }
    }
}
