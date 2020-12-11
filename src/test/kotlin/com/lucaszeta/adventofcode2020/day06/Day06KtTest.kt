package com.lucaszeta.adventofcode2020.day06

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06KtTest {

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
            "b\n"
        val expectedOutput = listOf(
            listOf("abc"),
            listOf("a", "b", "c"),
            listOf("ab", "ac"),
            listOf("a", "a", "a", "a"),
            listOf("b")
        )

        assertEquals(expectedOutput, parseData(input))
    }

    @Test
    fun `Should count unique questions anyone answered`() {
        assertEquals(3, countQuestionsAnyoneAnswered(listOf("abc")))
        assertEquals(3, countQuestionsAnyoneAnswered(listOf("a", "b", "c")))
        assertEquals(3, countQuestionsAnyoneAnswered(listOf("ab", "ac")))
        assertEquals(1, countQuestionsAnyoneAnswered(listOf("a", "a", "a", "a")))
        assertEquals(1, countQuestionsAnyoneAnswered(listOf("b")))
    }

    @Test
    fun `Should count unique questions everyone answered`() {
        assertEquals(3, countQuestionsEveryoneAnswered(listOf("abc")))
        assertEquals(0, countQuestionsEveryoneAnswered(listOf("a", "b", "c")))
        assertEquals(1, countQuestionsEveryoneAnswered(listOf("ab", "ac")))
        assertEquals(1, countQuestionsEveryoneAnswered(listOf("a", "a", "a", "a")))
        assertEquals(1, countQuestionsEveryoneAnswered(listOf("b")))
    }
}
