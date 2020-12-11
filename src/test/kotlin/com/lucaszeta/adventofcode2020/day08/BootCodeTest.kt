package com.lucaszeta.adventofcode2020.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
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

    @Test
    fun `Should finish execution early when there is an infinite loop`() {
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

        val bootCode = BootCode(input)

        assertFalse(bootCode.runProgram())
        assertEquals(5, bootCode.accumulator)
    }

    @Test
    fun `Should finish execution successfully when there is no infinite loop`() {
        val input = listOf(
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

        val bootCode = BootCode(input)

        assertTrue(bootCode.runProgram())
        assertEquals(8, bootCode.accumulator)
    }
}
