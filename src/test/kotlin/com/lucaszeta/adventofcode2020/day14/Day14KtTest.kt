package com.lucaszeta.adventofcode2020.day14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class Day14KtTest {

    @Test
    fun `Should extract mask from input`() {
        val input = "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"
        val expectedOutput = listOf(
            "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X",
            "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X",
            "X", "X", "X", "1", "X", "X", "X", "X", "0", "X"
        )

        assertEquals(expectedOutput, extractMask(input))
    }

    @Test
    fun `Should not extract mask from invalid input`() {
        val input = "invalidkey = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"

        assertNull(extractMask(input))
    }

    @Test
    fun `Should extract memory from input`() {
        val input = "mem[7] = 101"
        val expectedOutput = 7 to listOf("1", "1", "0", "0", "1", "0", "1")

        assertEquals(expectedOutput, extractMemory(input))
    }

    @Test
    fun `Should not extract memory from invalid input`() {
        listOf(
            "mem[xx] = 101",
            "invalidkey[7] = 101",
            "mem[7] = invalidvalue"
        ).forEach {
            assertNull(extractMask(it))
        }
    }

    @Test
    fun `Should apply mask to memory`() {
        val bitmask = listOf(
            "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X",
            "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X",
            "X", "X", "X", "1", "X", "X", "X", "X", "0", "X"
        )
        val memory1 = listOf("1", "0", "1", "1")
        val memory2 = listOf("0")

        assertEquals(73L, applyMask(bitmask, memory1))
        assertEquals(64L, applyMask(bitmask, memory2))
    }

    @Test
    fun `Should process all instructions`() {
        val input = listOf(
            "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
            "mem[8] = 11",
            "mem[7] = 101",
            "mem[8] = 0"
        )
        val expectedOutput = mapOf(
            7L to 101L,
            8L to 64L
        )

        assertEquals(expectedOutput, processInstructions(input))
    }

    @Test
    fun `Should fetch addresses`() {
        val bitmask = listOf(
            "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
            "0", "0", "X", "1", "0", "0", "1", "X"
        )
        val address = 42

        val expectedOutput = listOf(26L, 27L, 58L, 59L)

        assertEquals(expectedOutput, fetchAddressList(bitmask, address))
    }

    @Test
    fun `Should process all instructions with V2 decoder`() {
        val input = listOf(
            "mask = 000000000000000000000000000000X1001X",
            "mem[42] = 100",
            "mask = 00000000000000000000000000000000X0XX",
            "mem[26] = 1"
        )
        val expectedOutput = mapOf(
            26L to 1L,
            27L to 1L,
            58L to 100L,
            59L to 100L,
            16L to 1L,
            17L to 1L,
            18L to 1L,
            19L to 1L,
            24L to 1L,
            25L to 1L
        )

        assertEquals(expectedOutput, processInstructionsV2(input))
    }
}
