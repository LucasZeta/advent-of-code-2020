package com.lucaszeta.adventofcode2020.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day6Test {

    @Test
    fun `Should parse data`() {
        val input = "abc\n" +
            "\n" +
            "a\n" +
            "b\n" +
            "c\n" +
            "\n" +
            "ab\n" +
            "ac\n" +
            "\n" +
            "a\n" +
            "a\n" +
            "a\n" +
            "a\n" +
            "\n" +
            "b"
        val expectedOutput = listOf(
            "abc",
            "abc",
            "abac",
            "aaaa",
            "b"
        )

        assertEquals(expectedOutput, parseData(input))
    }

    @Test
    fun `Should count unique questions answered`() {
        assertEquals(3, countQuestions("abc"))
        assertEquals(3, countQuestions("abac"))
        assertEquals(1, countQuestions("aaaa"))
        assertEquals(1, countQuestions("a"))
    }
}
