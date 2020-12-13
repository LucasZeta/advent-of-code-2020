package com.lucaszeta.adventofcode2020.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day13KtTest {

    @Test
    fun `Should parse all Bus data`() {
        val input = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )
        val expectedOutput = 939 to listOf(
            Bus(7, 0),
            Bus(13, 1),
            Bus(59, 4),
            Bus(31, 6),
            Bus(19, 7)
        )

        assertEquals(expectedOutput, parseBusData(input))
    }

    @Test
    fun `Should find nearest bus arrival`() {
        val timestamp = 939
        val buses = listOf(
            Bus(7, 0),
            Bus(13, 1),
            Bus(59, 4),
            Bus(31, 6),
            Bus(19, 7)
        )

        assertEquals(59L to 5L, calculateNearestBusArrival(buses, timestamp))
    }
}
