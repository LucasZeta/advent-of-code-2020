package com.lucaszeta.adventofcode2020.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5KtTest {

    @Test
    fun `Should calculate seat ID`() {
        assertEquals(567, calculateSeatId(70 to 7))
        assertEquals(119, calculateSeatId(14 to 7))
        assertEquals(820, calculateSeatId(102 to 4))
    }

    @Test
    fun `Should convert row coordinates to binary`() {
        val actualValue = listOf("F", "B", "F", "B", "B", "F", "F").toBinaryString("F")
        assertEquals("1010011", actualValue)
    }

    @Test
    fun `Should convert column coordinates to binary`() {
        val actualValue = listOf("R", "L", "R").toBinaryString("R")
        assertEquals("101", actualValue)
    }

    @Test
    fun `Should find correct seat`() {
        assertEquals(44 to 5, findSeat("FBFBBFFRLR"))
    }

    @Test
    fun `Should find missing gap between seats`() {
        val missingSeatId = 34
        val seatIds = (4 until 280).toList().filter { it != missingSeatId }

        assertEquals(missingSeatId, findMissingSeat(seatIds))
    }
}
