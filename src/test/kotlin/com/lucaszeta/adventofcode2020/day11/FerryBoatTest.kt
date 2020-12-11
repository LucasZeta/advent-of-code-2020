package com.lucaszeta.adventofcode2020.day11

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FerryBoatTest {

    @Test
    fun `Should map input data`() {
        val input = listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        )
        val expectedOutput = listOf(
            listOf('L', '.', 'L', 'L', '.', 'L', 'L', '.', 'L', 'L'),
            listOf('L', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L', 'L'),
            listOf('L', '.', 'L', '.', 'L', '.', '.', 'L', '.', '.'),
            listOf('L', 'L', 'L', 'L', '.', 'L', 'L', '.', 'L', 'L'),
            listOf('L', '.', 'L', 'L', '.', 'L', 'L', '.', 'L', 'L'),
            listOf('L', '.', 'L', 'L', 'L', 'L', 'L', '.', 'L', 'L'),
            listOf('.', '.', 'L', '.', 'L', '.', '.', '.', '.', '.'),
            listOf('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'),
            listOf('L', '.', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L'),
            listOf('L', '.', 'L', 'L', 'L', 'L', 'L', '.', 'L', 'L')
        )

        val ferryBoat = FerryBoat(input)
        assertEquals(expectedOutput, ferryBoat.seatLayout)
    }

    @Test
    fun `Should occupy all seats when they are empty`() {
        val input = listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        )
        val expectedOutput = listOf(
            listOf('#', '.', '#', '#', '.', '#', '#', '.', '#', '#'),
            listOf('#', '#', '#', '#', '#', '#', '#', '.', '#', '#'),
            listOf('#', '.', '#', '.', '#', '.', '.', '#', '.', '.'),
            listOf('#', '#', '#', '#', '.', '#', '#', '.', '#', '#'),
            listOf('#', '.', '#', '#', '.', '#', '#', '.', '#', '#'),
            listOf('#', '.', '#', '#', '#', '#', '#', '.', '#', '#'),
            listOf('.', '.', '#', '.', '#', '.', '.', '.', '.', '.'),
            listOf('#', '#', '#', '#', '#', '#', '#', '#', '#', '#'),
            listOf('#', '.', '#', '#', '#', '#', '#', '#', '.', '#'),
            listOf('#', '.', '#', '#', '#', '#', '#', '.', '#', '#')
        )

        val ferryBoat = FerryBoat(input)
        ferryBoat.simulateSeatOccupation()

        assertEquals(expectedOutput, ferryBoat.seatLayout)
    }

    @Test
    fun `Should abandon seats with four or more occupied adjacent seats`() {
        val input = listOf(
            "#.##.##.##",
            "#######.##",
            "#.#.#..#..",
            "####.##.##",
            "#.##.##.##",
            "#.#####.##",
            "..#.#.....",
            "##########",
            "#.######.#",
            "#.#####.##"
        )
        val expectedOutput = listOf(
            listOf('#', '.', 'L', 'L', '.', 'L', '#', '.', '#', '#'),
            listOf('#', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L', '#'),
            listOf('L', '.', 'L', '.', 'L', '.', '.', 'L', '.', '.'),
            listOf('#', 'L', 'L', 'L', '.', 'L', 'L', '.', 'L', '#'),
            listOf('#', '.', 'L', 'L', '.', 'L', 'L', '.', 'L', 'L'),
            listOf('#', '.', 'L', 'L', 'L', 'L', '#', '.', '#', '#'),
            listOf('.', '.', 'L', '.', 'L', '.', '.', '.', '.', '.'),
            listOf('#', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', '#'),
            listOf('#', '.', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L'),
            listOf('#', '.', '#', 'L', 'L', 'L', 'L', '.', '#', '#')
        )

        val ferryBoat = FerryBoat(input)
        ferryBoat.simulateSeatOccupation()

        assertEquals(expectedOutput, ferryBoat.seatLayout)
    }
}
