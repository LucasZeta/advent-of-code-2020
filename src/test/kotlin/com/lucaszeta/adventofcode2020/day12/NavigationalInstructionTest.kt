package com.lucaszeta.adventofcode2020.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NavigationalInstructionTest {

    @Test
    fun `Should map input data`() {
        listOf(
            "N2" to NavigationalInstruction(Direction.NORTH, 2),
            "L180" to NavigationalInstruction(Direction.LEFT, 180),
            "F14" to NavigationalInstruction(Direction.FORWARD, 14),
            "S1" to NavigationalInstruction(Direction.SOUTH, 1),
            "W3" to NavigationalInstruction(Direction.WEST, 3),
            "R270" to NavigationalInstruction(Direction.RIGHT, 270),
            "E12" to NavigationalInstruction(Direction.EAST, 12),
        ).forEach { (input, expectedOutput) ->
            assertEquals(expectedOutput, NavigationalInstruction(input))
        }
    }
}
