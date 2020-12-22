package com.lucaszeta.adventofcode2020.day22

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val decks = getResourceAsText("/day22/decks.txt")
        .split("\n\n")
        .map(::parseDeck)

    val winnerDeck = playCombat(decks[0], decks[1])

    println("Combat")
    println("Winner deck: $winnerDeck")
    println("Score: ${calculateScore(winnerDeck)}")

    val (_, recursiveWinnerDeck) = playRecursiveCombat(decks[0], decks[1])

    println("Recursive Combat")
    println("Winner deck: $recursiveWinnerDeck")
    println("Score: ${calculateScore(recursiveWinnerDeck)}")
}

fun calculateScore(winnerDeck: List<Int>): Int {
    var multiplier = 2

    return winnerDeck
        .reversed()
        .reduce { acc, card ->
            acc + card * multiplier++
        }
}

fun playCombat(deck1: List<Int>, deck2: List<Int>): List<Int> {
    val player1Deck = deck1.toMutableList()
    val player2Deck = deck2.toMutableList()

    while (player1Deck.isNotEmpty() && player2Deck.isNotEmpty()) {
        playCombatRound(player1Deck, player2Deck)
    }

    return if (player1Deck.isNotEmpty()) {
        player1Deck.toList()
    } else {
        player2Deck.toList()
    }
}

fun playCombatRound(
    player1Deck: MutableList<Int>,
    player2Deck: MutableList<Int>
) {
    val player1Card = player1Deck.removeFirst()
    val player2Card = player2Deck.removeFirst()

    if (player1Card > player2Card) {
        player1Deck.add(player1Card)
        player1Deck.add(player2Card)
    } else {
        player2Deck.add(player2Card)
        player2Deck.add(player1Card)
    }
}

fun parseDeck(input: String) = input
    .split("\n")
    .filter { "(\\d+)".toRegex().matches(it) }
    .map { it.toInt() }
