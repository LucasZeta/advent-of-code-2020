package com.lucaszeta.adventofcode2020.day11

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val seatLayout = getResourceAsText("/day11/seat-layout.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val ferry = FerryBoat(seatLayout)

    var previousSeatLayout = listOf<List<Char>>()

    do {
        previousSeatLayout = ferry.seatLayout

        ferry.simulateSeatOccupation()
    } while (ferry.seatLayout != previousSeatLayout)

    println("Seats occupied: ${ferry.countOccupiedSeats()}")
}
