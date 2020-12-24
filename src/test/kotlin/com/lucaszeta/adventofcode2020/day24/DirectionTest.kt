package com.lucaszeta.adventofcode2020.day24

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class DirectionTest {

    @Test
    fun `Should map coordinate to enum`() {
        assertEquals(Direction.SOUTHEAST, Direction.fromCoordinate("se"))
        assertEquals(Direction.EAST, Direction.fromCoordinate("e"))
        assertEquals(Direction.NORTHWEST, Direction.fromCoordinate("nw"))
    }

    @Test
    fun `Should throw exception when coordinate is invalid`() {
        assertThrows<IllegalArgumentException> {
            Direction.fromCoordinate("sxsw")
        }
    }

    @Test
    fun `Should return all possible directions`() {
        val directions = Direction.allDirections()

        assertTrue(directions.contains("e"))
        assertTrue(directions.contains("se"))
        assertTrue(directions.contains("ne"))
        assertTrue(directions.contains("w"))
        assertTrue(directions.contains("sw"))
        assertTrue(directions.contains("nw"))
    }
}
