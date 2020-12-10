package com.lucaszeta.adventofcode2020.day10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day10KtTest {

    @Test
    fun `Should find device adapter joltage`() {
        val input = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

        assertEquals(22, findDeviceAdapterJoltage(input))
    }
}
