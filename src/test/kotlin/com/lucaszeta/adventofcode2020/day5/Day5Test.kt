package com.lucaszeta.adventofcode2020.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun `Should calculate seat ID`() {
        assertEquals(567, calculateSeatId(70 to 7))
        assertEquals(119, calculateSeatId(14 to 7))
        assertEquals(820, calculateSeatId(102 to 4))
    }

    @Test
    fun `Should read coordinates and find row`() {
        val seats = (0 until 128).toList()
        val coordinates = listOf("F", "B", "F", "B", "B", "F", "F")

        assertEquals(44, searchNumber(seats, coordinates, "F", "B"))
    }

    @Test
    fun `Should read coordinates and find column`() {
        val seats = (0 until 8).toList()
        val coordinates = listOf("R", "L", "R")

        assertEquals(5, searchNumber(seats, coordinates, "L", "R"))
    }

    @Test
    fun `Should find correct seat`() {
        assertEquals(44 to 5, findSeat("FBFBBFFRLR"))
    }
}
