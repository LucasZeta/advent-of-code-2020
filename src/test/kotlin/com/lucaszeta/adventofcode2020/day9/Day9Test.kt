package com.lucaszeta.adventofcode2020.day9

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day9Test {

    @Test
    fun `Should find number not product of sum of previous numbers`() {
        val input = listOf(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182,
            127,
            219,
            299,
            277,
            309,
            576
        ).map { it.toLong() }

        assertEquals(127, findNumberNotSumOfPrevious(input, 5))
    }
}
