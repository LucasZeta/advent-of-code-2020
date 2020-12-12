package com.lucaszeta.adventofcode2020.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FerryBoatNavigationalSystemTest {

    @Test
    fun `Should move according to N, E, W, S coordinates`() {
        val input = listOf(
            "N3",
            "E4",
            "S7",
            "W1"
        ).map(::NavigationalInstruction)

        val navigationalSystem = FerryBoatNavigationalSystem(input)
        navigationalSystem.navigate()

        assertEquals(-4, navigationalSystem.currentPositionY)
        assertEquals(3, navigationalSystem.currentPositionX)
    }

    @Test
    fun `Should change direction of the boat`() {
        listOf(
            listOf("L90", "L180") to Direction.SOUTH,
            listOf("R270") to Direction.NORTH,
            listOf("L180", "L180") to Direction.EAST,
            listOf("R270", "L90") to Direction.WEST,
        ).forEach { (instructionsString, expectedDirection) ->
            val navigationalSystem = FerryBoatNavigationalSystem(
                instructionsString.map(::NavigationalInstruction)
            )
            navigationalSystem.navigate()

            assertEquals(expectedDirection, navigationalSystem.currentDirection)
        }
    }
}
