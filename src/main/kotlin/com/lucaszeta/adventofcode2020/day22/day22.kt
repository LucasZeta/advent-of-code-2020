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

fun parseDeck(input: String): List<Int> {
    val onlyNumbers = "(\\d+)".toRegex()

    return input
        .split("\n")
        .filter { onlyNumbers.matches(it) }
        .map { it.toInt() }
}
