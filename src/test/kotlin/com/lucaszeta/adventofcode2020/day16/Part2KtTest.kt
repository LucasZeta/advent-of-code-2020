package com.lucaszeta.adventofcode2020.day16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Part2KtTest {

    @Test
    fun `Should filter invalid values`() {
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

        val expectedOutput = listOf(listOf(7, 3, 47))

        assertEquals(expectedOutput, filterValidTickets(nearbyTickets, fields))
    }

    @Test
    fun `Should identify fields' positions based on indexes where they are valid`() {
        val fields = mapOf(
            "class" to listOf(0..1, 4..19),
            "row" to listOf(0..5, 8..19),
            "seat" to listOf(0..13, 16..19)
        )

        val nearbyTickets = listOf(
            listOf(3, 9, 18),
            listOf(15, 1, 5),
            listOf(5, 14, 9)
        )

        val expectedOutput = mapOf(
            "row" to 0,
            "class" to 1,
            "seat" to 2
        )

        assertEquals(expectedOutput, identifyFieldIndex(nearbyTickets, fields))
    }
}
