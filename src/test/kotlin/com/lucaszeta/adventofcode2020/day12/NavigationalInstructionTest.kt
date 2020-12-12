package com.lucaszeta.adventofcode2020.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

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

    @Test
    fun `Should thrown exception when mapping invalid data`() {
        listOf(
            "X9",
            "Nxx",
            "L"
        ).forEach {
            assertThrows<IllegalArgumentException> {
                NavigationalInstruction(it)
            }
        }
    }
}
