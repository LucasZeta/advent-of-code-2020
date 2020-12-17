package com.lucaszeta.adventofcode2020.day16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Part1KtTest {

    @Test
    fun `Should find values that are not in any range`() {
        val fields = mapOf(
            "class" to listOf(1..3, 5..7),
            "row" to listOf(6..11, 33..44),
            "seat" to listOf(13..40, 45..50)
        )

        val nearbyTickets = listOf(
            listOf(7, 3, 47),
            listOf(40, 4, 50),
            listOf(55, 2, 20),
            listOf(38, 6, 12),
        )

        val expectedOutput = listOf(4, 55, 12)

        assertEquals(expectedOutput, findInvalidFields(nearbyTickets, fields))
    }
}
