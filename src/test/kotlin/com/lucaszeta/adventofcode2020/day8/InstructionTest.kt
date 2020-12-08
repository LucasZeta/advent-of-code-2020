package com.lucaszeta.adventofcode2020.day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InstructionTest {

    @Test
    fun `Should map input data`() {
        val instruction = Instruction("nop +0")

        assertEquals(Operator.NOP, instruction.operator)
        assertEquals(0, instruction.argument)
    }

    @Test
    fun `Should map negative values`() {
        val instruction = Instruction("acc -99")

        assertEquals(Operator.ACC, instruction.operator)
        assertEquals(-99, instruction.argument)
    }
}
