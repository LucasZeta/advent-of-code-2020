package com.lucaszeta.adventofcode2020.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaypointNavigationSystemTest {

    @Test
    fun `Should move waypoint according to N, E, W, S coordinates`() {
        val input = listOf(
            "N3",
            "E4",
            "S7",
            "W1"
        ).map(::NavigationalInstruction)

        val navigationalSystem = WaypointNavigationSystem(input, 10, 1)
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
            val navigationalSystem = WaypointNavigationSystem(
                instructionsString.map(::NavigationalInstruction),
                10,
                4
            )
            navigationalSystem.navigate()

            assertEquals(expectedWaypoint.first, navigationalSystem.waypointX)
            assertEquals(expectedWaypoint.second, navigationalSystem.waypointY)
        }
    }

    @Test
    fun `Should move forward x units towards waypoint`() {
        listOf(
            listOf("L90", "F32") to (-32 to 64),
            listOf("L270", "F9") to (9 to -18),
            listOf("R180", "F4") to (-8 to -4),
            listOf("R360", "F50") to (100 to 50),
        ).forEach { (instructionsString, expectedPosition) ->
            val navigationalSystem = WaypointNavigationSystem(
                instructionsString.map(::NavigationalInstruction),
                2,
                1
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

        val navigationalSystem = WaypointNavigationSystem(input, 10, 1)
        navigationalSystem.navigate()

        assertEquals(214, navigationalSystem.currentPositionX)
        assertEquals(-72, navigationalSystem.currentPositionY)
    }
}
