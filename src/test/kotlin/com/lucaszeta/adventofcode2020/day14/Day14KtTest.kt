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
}
