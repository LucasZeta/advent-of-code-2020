package com.lucaszeta.adventofcode2020.day22

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
