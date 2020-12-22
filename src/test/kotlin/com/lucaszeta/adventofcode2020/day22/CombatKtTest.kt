package com.lucaszeta.adventofcode2020.day22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombatKtTest {

    @Test
    fun `Should add cards to the deck with the higher round card`() {
        val deck1 = mutableListOf(9, 2, 6, 3, 1)
        val deck2 = mutableListOf(5, 8, 4, 7, 10)

        playCombatRound(deck1, deck2)

        assertEquals(listOf(2, 6, 3, 1, 9, 5), deck1)
        assertEquals(listOf(8, 4, 7, 10), deck2)
    }

    @Test
    fun `Should play rounds until one deck has all cards`() {
        val deck1 = listOf(9, 2, 6, 3, 1)
        val deck2 = listOf(5, 8, 4, 7, 10)

        val winnerDeck = playCombat(deck1, deck2)

        assertEquals(listOf(3, 2, 10, 6, 8, 5, 9, 4, 7, 1), winnerDeck)
    }
}
