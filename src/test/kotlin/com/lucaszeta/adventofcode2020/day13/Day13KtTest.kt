package com.lucaszeta.adventofcode2020.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day13KtTest {

    @Test
    fun `Should parse valid busIds data`() {
        val input = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )
        val expectedOutput = 939 to listOf(7, 13, 59, 31, 19)

        assertEquals(expectedOutput, parseValidBusIdData(input))
    }

    @Test
    fun `Should find nearest bus arrival`() {
        val timestamp = 939
        val busIds = listOf(7, 13, 59, 31, 19)

        assertEquals(59 to 5, calculateNearestBusArrival(busIds, timestamp))
    }

    @Test
    fun `Should find sequential departure time`() {
        listOf(
            listOf(7, 13, 1, 1, 59, 1, 31, 19) to 1068781L,
            listOf(17, 1, 13, 19) to 3417L,
            listOf(67, 7, 59, 61) to 754018L,
            listOf(67, 1, 7, 59, 61) to 779210L,
            listOf(67, 7, 1, 59, 61) to 1261476L,
            listOf(1789, 37, 47, 1889) to 1202161486L
        ).forEach { (input, expectedOutput) ->
            assertEquals(
                expectedOutput,
                calculateSequentialBusDepartures(input.map { it.toLong() })
            )
        }
    }
}
