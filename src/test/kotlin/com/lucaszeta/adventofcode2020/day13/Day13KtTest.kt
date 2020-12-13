package com.lucaszeta.adventofcode2020.day13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day13KtTest {

    @Test
    fun `Should find nearest bus arrival`() {
        val timestamp = 939
        val busIds = listOf(7, 13, 59, 31, 19)

        assertEquals(59 to 5, calculateNearestBusArrival(busIds, timestamp))
    }
}