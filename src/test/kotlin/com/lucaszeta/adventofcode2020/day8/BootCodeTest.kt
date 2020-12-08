package com.lucaszeta.adventofcode2020.day8

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BootCodeTest {

    @Test
    fun `Should do nothing and go to next line when receiving NOP`() {
        val bootCode = BootCode(listOf(Instruction(Operator.NOP, 3)))
        bootCode.executeInstruction()

        assertEquals(0, bootCode.accumulator)
        assertEquals(1, bootCode.currentIndex)
    }

    @Test
    fun `Should accumulate value and go to next line when receiving ACC`() {
        val bootCode = BootCode(listOf(Instruction(Operator.ACC, 3)))
        bootCode.executeInstruction()

        assertEquals(3, bootCode.accumulator)
        assertEquals(1, bootCode.currentIndex)
    }

    @Test
    fun `Should jump N lines when receiving JMP`() {
        val bootCode = BootCode(listOf(Instruction(Operator.JMP, 3)))
        bootCode.executeInstruction()

        assertEquals(0, bootCode.accumulator)
        assertEquals(3, bootCode.currentIndex)
    }
}
