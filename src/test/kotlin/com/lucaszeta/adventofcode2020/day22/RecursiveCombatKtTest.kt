package com.lucaszeta.adventofcode2020.day22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RecursiveCombatKtTest {

    @Test
    fun `Should give win to deck with higher round card`() {
        val winnerDeck = mutableListOf(9, 2, 6, 3, 1)
        val loserDeck = mutableListOf(5, 8, 4, 7, 10)

        assertTrue(playRecursiveCombatRound(winnerDeck, loserDeck))
        assertFalse(playRecursiveCombatRound(loserDeck, winnerDeck))
    }

    @Test
    fun `Should resolve inner game if round card is lower than remaining cards count`() {
        val deck1 = mutableListOf(4, 9, 8, 5, 2)
        val deck2 = mutableListOf(3, 10, 1, 7, 6)

        val deck1Won = playRecursiveCombatRound(deck1, deck2)

        assertFalse(deck1Won)
    }

    @Test
    fun `Should play rounds until one deck has all cards`() {
        val deck1 = listOf(9, 2, 6, 3, 1)
        val deck2 = listOf(5, 8, 4, 7, 10)

        val (deck1Won, winnerDeck) = playRecursiveCombat(deck1, deck2)

        assertFalse(deck1Won)
        assertEquals(listOf(7, 5, 6, 2, 4, 1, 10, 8, 9, 3), winnerDeck)
    }
}
