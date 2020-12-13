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
    fun `Should parse all Bus data`() {
        val input = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )
        val expectedOutput = listOf(
            Bus(7, 0),
            Bus(13, 1),
            Bus(59, 4),
            Bus(31, 6),
            Bus(19, 7)
        )

        assertEquals(expectedOutput, parseAllBusIdData(input))
    }

    @Test
    fun `Should find sequential departure time`() {
        listOf(
            "939\n7,13,x,x,59,x,31,19" to 1068781L,
            "0\n17,x,13,19" to 3417L,
            "0\n67,7,59,61" to 754018L,
            "0\n67,x,7,59,61" to 779210L,
            "0\n67,7,x,59,61" to 1261476L,
            "0\n1789,37,47,1889" to 1202161486L,
        ).forEach { (input, expectedOutput) ->
            assertEquals(
                expectedOutput,
                calculateSequentialBusDepartures(
                    parseAllBusIdData(input.split("\n"))
                )
            )
        }
    }
}
