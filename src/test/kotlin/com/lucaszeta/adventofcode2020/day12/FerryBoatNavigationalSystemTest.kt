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

    @Test
    fun `Should go forward in the current direction`() {
        listOf(
            listOf("L90", "F32") to (0 to 32),
            listOf("L270", "F9") to (0 to -9),
            listOf("R180", "F4") to (-4 to 0),
            listOf("R360", "F50") to (50 to 0),
        ).forEach { (instructionsString, expectedPosition) ->
            val navigationalSystem = FerryBoatNavigationalSystem(
                instructionsString.map(::NavigationalInstruction)
            )
            navigationalSystem.navigate()

            assertEquals(expectedPosition.first, navigationalSystem.currentPositionX)
            assertEquals(expectedPosition.second, navigationalSystem.currentPositionY)
        }
    }

    @Test
    fun `Should navigate to destination`() {
        val input = listOf("F10", "N3", "F7", "R90", "F11")
            .map(::NavigationalInstruction)

        val navigationalSystem = FerryBoatNavigationalSystem(input)
        navigationalSystem.navigate()

        assertEquals(17, navigationalSystem.currentPositionX)
        assertEquals(-8, navigationalSystem.currentPositionY)
    }
}
