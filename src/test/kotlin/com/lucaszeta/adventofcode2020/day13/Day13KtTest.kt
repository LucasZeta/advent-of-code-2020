package com.lucaszeta.adventofcode2020.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day13KtTest {

    @Test
    fun `Should parse input data`() {
        val input = "939\n" +
            "7,13,x,x,59,x,31,19\n" +
            ""
        val expectedOutput = 939 to listOf(7, 13, 59, 31, 19)

        assertEquals(expectedOutput, parseData(input))
    }

    @Test
    fun `Should find nearest bus arrival`() {
        val timestamp = 939
        val busIds = listOf(7, 13, 59, 31, 19)

        assertEquals(59 to 5, calculateNearestBusArrival(busIds, timestamp))
    }
}
