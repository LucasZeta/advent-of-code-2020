package com.lucaszeta.adventofcode2020.day22

fun playRecursiveCombat(
    deck1: List<Int>,
    deck2: List<Int>
): Pair<Boolean, List<Int>> {
    val player1Deck = deck1.toMutableList()
    val player2Deck = deck2.toMutableList()

    while (player1Deck.isNotEmpty() && player2Deck.isNotEmpty()) {
        val player1Won = playRecursiveCombatRound(player1Deck, player2Deck)

        if (player1Won) {
            player1Deck.add(player1Deck.removeFirst())
            player1Deck.add(player2Deck.removeFirst())
        } else {
            player2Deck.add(player2Deck.removeFirst())
            player2Deck.add(player1Deck.removeFirst())
        }
    }

    val player1Won = player1Deck.isNotEmpty()
    val winnerDeck = if (player1Won) {
        player1Deck.toList()
    } else {
        player2Deck.toList()
    }

    return player1Won to winnerDeck
}

fun playRecursiveCombatRound(
    player1Deck: MutableList<Int>,
    player2Deck: MutableList<Int>
): Boolean {
    val player1Card = player1Deck.first()
    val player2Card = player2Deck.first()

    if (player1Card <= player1Deck.size - 1 && player2Card <= player2Deck.size - 1) {
        val (player1Won, _) = playRecursiveCombat(
            player1Deck.slice(1..(player1Card)),
            player2Deck.slice(1..(player2Card)),
        )

        return player1Won
    }

    return player1Card > player2Card
}
