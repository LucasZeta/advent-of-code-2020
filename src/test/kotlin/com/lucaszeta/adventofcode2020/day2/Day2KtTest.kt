package com.lucaszeta.adventofcode2020.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2KtTest {

    @Test
    fun `Should count Sled Rental valid passwords`() {
        val input = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
        )

        assertEquals(2, countSledRentalValidPasswords(input))
    }

    @Test
    fun `Should count Toboggan Corporate valid passwords`() {
        val input = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
        )

        assertEquals(1, countTobogganValidPasswords(input))
    }
}