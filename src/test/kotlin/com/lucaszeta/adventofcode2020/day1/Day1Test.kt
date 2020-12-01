package com.lucaszeta.adventofcode2020.day1

import org.junit.Assert.assertEquals
import org.junit.Test

class Day1Test {

    @Test
    fun shouldFindNumbersThatSum2020() {
        val input = listOf(1721, 979, 366, 299, 675, 1456)

        assertEquals(1721 to 299, findNumbers(input, 2020))
    }
}
