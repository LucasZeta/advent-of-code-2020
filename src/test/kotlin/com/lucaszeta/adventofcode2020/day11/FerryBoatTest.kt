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
    fun `Should occupy seats when the adjacent ones are empty`() {
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

    @Test
    fun `Should occupy seats when the visible ones are empty`() {
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
            .apply { setNewOccupationRules() }
        ferryBoat.simulateSeatOccupation()

        assertEquals(expectedOutput, ferryBoat.seatLayout)
    }

    @Test
    fun `Should abandon seats with five or more occupied visible seats`() {
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
            listOf('#', '.', 'L', 'L', '.', 'L', 'L', '.', 'L', '#'),
            listOf('#', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L', 'L'),
            listOf('L', '.', 'L', '.', 'L', '.', '.', 'L', '.', '.'),
            listOf('L', 'L', 'L', 'L', '.', 'L', 'L', '.', 'L', 'L'),
            listOf('L', '.', 'L', 'L', '.', 'L', 'L', '.', 'L', 'L'),
            listOf('L', '.', 'L', 'L', 'L', 'L', 'L', '.', 'L', 'L'),
            listOf('.', '.', 'L', '.', 'L', '.', '.', '.', '.', '.'),
            listOf('L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', '#'),
            listOf('#', '.', 'L', 'L', 'L', 'L', 'L', 'L', '.', 'L'),
            listOf('#', '.', 'L', 'L', 'L', 'L', 'L', '.', 'L', '#')
        )

        val ferryBoat = FerryBoat(input)
            .apply { setNewOccupationRules() }
        ferryBoat.simulateSeatOccupation()

        assertEquals(expectedOutput, ferryBoat.seatLayout)
    }

    @Test
    fun `Should count occupied seats`() {
        val input = listOf(
            "#.#L.L#.##",
            "#LLL#LL.L#",
            "L.#.L..#..",
            "#L##.##.L#",
            "#.#L.LL.LL",
            "#.#L#L#.##",
            "..L.L.....",
            "#L#L##L#L#",
            "#.LLLLLL.L",
            "#.#L#L#.##"
        )

        val ferryBoat = FerryBoat(input)

        assertEquals(37, ferryBoat.countOccupiedSeats())
    }
}
