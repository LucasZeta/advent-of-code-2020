package com.lucaszeta.adventofcode2020.day11

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val seatLayout = getResourceAsText("/day11/seat-layout.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    println("Seats occupied by old rules: ${countSeats(seatLayout)}")
    println("Seats occupied by new rules: ${countSeats(seatLayout, newOccupationRules = true)}")
}

fun countSeats(
    seatLayout: List<String>,
    newOccupationRules: Boolean = false
): Int {
    val ferry = FerryBoat(seatLayout)

    if (newOccupationRules) {
        ferry.setNewOccupationRules()
    }

    var previousSeatLayout: List<List<Char>>

    do {
        previousSeatLayout = ferry.seatLayout

        ferry.simulateSeatOccupation()
    } while (ferry.seatLayout != previousSeatLayout)

    return ferry.countOccupiedSeats()
}
