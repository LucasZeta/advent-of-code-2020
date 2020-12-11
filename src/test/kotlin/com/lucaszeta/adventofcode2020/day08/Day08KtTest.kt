package com.lucaszeta.adventofcode2020.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day08KtTest {

    @Test
    fun `Should change one instruction so the program exits successfully`() {
        val input = listOf(
            Instruction(Operator.NOP, 0),
            Instruction(Operator.ACC, 1),
            Instruction(Operator.JMP, 4),
            Instruction(Operator.ACC, 3),
            Instruction(Operator.JMP, -3),
            Instruction(Operator.ACC, -99),
            Instruction(Operator.ACC, 1),
            Instruction(Operator.JMP, -4),
            Instruction(Operator.ACC, 6)
        )

        val expectedOutput = listOf(
            Instruction(Operator.NOP, 0),
            Instruction(Operator.ACC, 1),
            Instruction(Operator.JMP, 4),
            Instruction(Operator.ACC, 3),
            Instruction(Operator.JMP, -3),
            Instruction(Operator.ACC, -99),
            Instruction(Operator.ACC, 1),
            Instruction(Operator.NOP, -4),
            Instruction(Operator.ACC, 6)
        )

        assertEquals(expectedOutput, fixInstructions(input))
    }
}
