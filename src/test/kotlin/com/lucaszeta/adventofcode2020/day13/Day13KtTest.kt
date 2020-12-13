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

    @Test
    fun `Should find sequential departure time`() {
        listOf(
            parseBusData(listOf("939", "7,13,x,x,59,x,31,19")) to 1068781L,
            parseBusData(listOf("0", "17,x,13,19")) to 3417L,
            parseBusData(listOf("0", "67,7,59,61")) to 754018L,
            parseBusData(listOf("0", "67,x,7,59,61")) to 779210L,
            parseBusData(listOf("0", "67,7,x,59,61")) to 1261476L,
            parseBusData(listOf("0", "1789,37,47,1889")) to 1202161486L
        ).forEach { (input, expectedOutput) ->
            assertEquals(
                expectedOutput,
                calculateSequentialBusDepartures(input.second)
            )
        }
    }
}
