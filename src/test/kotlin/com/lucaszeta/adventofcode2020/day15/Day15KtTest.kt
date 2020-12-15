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
}
