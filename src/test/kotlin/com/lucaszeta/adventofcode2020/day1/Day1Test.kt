package com.lucaszeta.adventofcode2020.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class Day1Test {

    @Test
    fun `Should find pair that sum to 2020`() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)

        assertEquals(1721 to 299, findPair(input, 2020))
    }

    @Test
    fun `Should find pair that sum to 2020, regardless of the list sorting`() {
        val input = listOf(1456, 979, 366, 675, 299, 1721)

        assertEquals(299 to 1721, findPair(input, 2020))
    }

    @Test
    fun `Should throw exception when not finding pair that sum to 2020`() {
        val input = listOf(1721, 979, 675, 1456)

        assertThrows<IllegalArgumentException> {
            findPair(input, 2020)
        }
    }

    @Test
    fun `Should find triple that sum to 2020`() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)

        assertEquals(Triple(979, 366, 675), findTriple(input, 2020))
    }

    @Test
    fun `Should find triple that sum to 2020, regardless of the list sorting`() {
        val input = listOf(366, 979, 675, 1456, 1721, 299)

        assertEquals(Triple(366, 979, 675), findTriple(input, 2020))
    }

    @Test
    fun `Should throw exception when not finding triple that sum to 2020`() {
        val input = listOf(1721, 979, 299, 675, 1456)

        assertThrows<IllegalArgumentException> {
            findTriple(input, 2020)
        }
    }
}
