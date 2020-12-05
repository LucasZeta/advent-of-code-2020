package com.lucaszeta.adventofcode2020.day5

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlin.math.pow

fun main() {
    val input = getResourceAsText("/day5/boarding-passes.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val highestSeatId = input
        .map(::findSeat)
        .map(::calculateSeatId)
        .max()!!

    println("Highest seat ID: %d".format(highestSeatId))
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
    val rowCoordinates = allCoordinates.filter { it == "F" || it == "B" }
    val columnCoordinates = allCoordinates.filter { it == "L" || it == "R" }

    val rows = 0 until (2.0.pow(rowCoordinates.size).toInt())
    val columns = 0 until (2.0.pow(columnCoordinates.size).toInt())

    val row = searchNumber(rows.toList(), rowCoordinates, "F", "B")
    val column = searchNumber(columns.toList(), columnCoordinates, "L", "R")

    return row to column
}

fun searchNumber(
    seats: List<Int>,
    coordinates: List<String>,
    lowerHalf: String,
    upperHalf: String
): Int {
    var remainingSeats = seats

    coordinates.forEach { coordinate ->
        val twoHalves = remainingSeats.chunked(remainingSeats.count() / 2)

        remainingSeats = if (coordinate == lowerHalf) twoHalves.first() else twoHalves.last()
    }

    return remainingSeats.first()
}
