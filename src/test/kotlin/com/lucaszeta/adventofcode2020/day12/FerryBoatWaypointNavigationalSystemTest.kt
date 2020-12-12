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

    @Test
    fun `Should change direction of the waypoint`() {
        listOf(
            listOf("L90", "L180") to (4 to -10),
            listOf("R270") to (-4 to 10),
            listOf("L180", "L180") to (10 to 4),
            listOf("R270", "L90") to (-10 to -4)
        ).forEach { (instructionsString, expectedWaypoint) ->
            val navigationalSystem = FerryBoatWaypointNavigationalSystem(
                instructionsString.map(::NavigationalInstruction),
                10,
                4
            )
            navigationalSystem.navigate()

            assertEquals(expectedWaypoint.first, navigationalSystem.waypointX)
            assertEquals(expectedWaypoint.second, navigationalSystem.waypointY)
        }
    }
}
