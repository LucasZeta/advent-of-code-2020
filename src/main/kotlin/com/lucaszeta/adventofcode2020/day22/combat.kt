package com.lucaszeta.adventofcode2020.day22

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
