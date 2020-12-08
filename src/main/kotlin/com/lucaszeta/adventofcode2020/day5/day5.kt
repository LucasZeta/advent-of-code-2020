package com.lucaszeta.adventofcode2020.day5

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val input = getResourceAsText("/day5/boarding-passes.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val seatIds = input
        .map(::findSeat)
        .map(::calculateSeatId)

    println("Highest seat ID: %d".format(seatIds.maxOrNull() ?: 0))
    println("Missing seat ID: %d".format(findMissingSeat(seatIds)))
}

fun findMissingSeat(seatIds: List<Int>): Int {
    val existingSeats = seatIds.sorted()

    return existingSeats
        .filterIndexed { index, seatId ->
            index != 0 && seatId - existingSeats[index - 1] > 1
        }
        .map { it - 1 }
        .first()
}

fun calculateSeatId(seatCoordinates: Pair<Int, Int>) =
    seatCoordinates.first * 8 + seatCoordinates.second

fun findSeat(coordinates: String): Pair<Int, Int> {
    val allCoordinates = coordinates.chunked(1)

    val rowCoordinates = allCoordinates
        .filter { it == "F" || it == "B" }
        .toBinaryString("B")
    val columnCoordinates = allCoordinates
        .filter { it == "L" || it == "R" }
        .toBinaryString("R")

    val row = Integer.parseInt(rowCoordinates, 2)
    val column = Integer.parseInt(columnCoordinates, 2)

    return row to column
}

fun List<String>.toBinaryString(characterOne: String): String {
    return map { if (it == characterOne) 1 else 0 }.joinToString("")
}
