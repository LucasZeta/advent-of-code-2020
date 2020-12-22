package com.lucaszeta.adventofcode2020.day22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day22KtTest {

    @Test
    fun `Should map input`() {
        listOf(
            "Player 1:\n" +
                "9\n" +
                "2\n" +
                "6\n" +
                "3\n" +
                "1" to listOf(9, 2, 6, 3, 1),
            "Player 2:\n" +
                "5\n" +
                "8\n" +
                "4\n" +
                "7\n" +
                "10" to listOf(5, 8, 4, 7, 10)
        ).forEach { (input, expectedOutput) ->
            assertEquals(expectedOutput, parseDeck(input))
        }
    }

    @Test
    fun `Should calculate deck's score`() {
        val winnerDeck = listOf(3, 2, 10, 6, 8, 5, 9, 4, 7, 1)

        assertEquals(306, calculateScore(winnerDeck))
    }
}
