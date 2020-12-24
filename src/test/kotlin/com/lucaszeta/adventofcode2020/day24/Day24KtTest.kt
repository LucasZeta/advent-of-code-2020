package com.lucaszeta.adventofcode2020.day24

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day24KtTest {

    @Test
    fun `Should map line to directions`() {
        listOf(
            "esenee" to listOf(
                Direction.EAST,
                Direction.SOUTHEAST,
                Direction.NORTHEAST,
                Direction.EAST
            ),
            "esew" to listOf(
                Direction.EAST,
                Direction.SOUTHEAST,
                Direction.WEST
            ),
            "nwwswee" to listOf(
                Direction.NORTHWEST,
                Direction.WEST,
                Direction.SOUTHWEST,
                Direction.EAST,
                Direction.EAST
            )
        ).forEach { (line, expectedDirections) ->
            assertEquals(expectedDirections, parseToDirections(line))
        }
    }

    @Test
    fun `Should find destination tile`() {
        listOf(
            listOf(
                Direction.EAST,
                Direction.SOUTHEAST,
                Direction.NORTHEAST,
                Direction.EAST
            ) to (3.0 to 0.0),
            listOf(
                Direction.EAST,
                Direction.SOUTHEAST,
                Direction.WEST
            ) to (0.5 to -1.0),
            listOf(
                Direction.NORTHWEST,
                Direction.WEST,
                Direction.SOUTHWEST,
                Direction.EAST,
                Direction.EAST
            ) to (0.0 to 0.0)
        ).forEach { (directions, expectedDestination) ->
            assertEquals(expectedDestination, navigateToTile(directions))
        }
    }
}
