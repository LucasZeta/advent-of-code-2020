package com.lucaszeta.adventofcode2020.day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class Day01KtTest {

    @Test
    fun `Should find pair that sum to 2020`() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)

        assertEquals(299 to 1721, findPair(input, 2020))
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

        assertEquals(Triple(366, 675, 979), findTriple(input, 2020))
    }

    @Test
    fun `Should find triple that sum to 2020, regardless of the list sorting`() {
        val input = listOf(366, 979, 675, 1456, 1721, 299)

        assertEquals(Triple(366, 675, 979), findTriple(input, 2020))
    }

    @Test
    fun `Should throw exception when not finding triple that sum to 2020`() {
        val input = listOf(1721, 979, 299, 675, 1456)

        assertThrows<IllegalArgumentException> {
            findTriple(input, 2020)
        }
    }
}
