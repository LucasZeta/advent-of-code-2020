package com.lucaszeta.adventofcode2020.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FerryBoatWaypointNavigationalSystemTest {

    @Test
    fun `Should move waypoint according to N, E, W, S coordinates`() {
        val input = listOf(
            "N3",
            "E4",
            "S7",
            "W1"
        ).map(::NavigationalInstruction)

        val navigationalSystem = FerryBoatWaypointNavigationalSystem(input, 10, 1)
        navigationalSystem.navigate()

        assertEquals(13, navigationalSystem.waypointX)
        assertEquals(-3, navigationalSystem.waypointY)
    }
}
