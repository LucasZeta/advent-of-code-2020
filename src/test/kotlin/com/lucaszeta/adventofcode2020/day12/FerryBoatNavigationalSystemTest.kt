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
}
