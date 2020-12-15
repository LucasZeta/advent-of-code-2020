package com.lucaszeta.adventofcode2020.day15

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day15KtTest {

    @Test
    fun `Should return 0 if number is new in the list`() {
        val input = listOf(0, 3, 6)

        assertEquals(0, nextNumber(input))
    }

    @Test
    fun `Should return sum of last two indexes if number is not new in the list`() {
        val input = listOf(0, 3, 6, 0)

        assertEquals(3, nextNumber(input))
    }

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
}
