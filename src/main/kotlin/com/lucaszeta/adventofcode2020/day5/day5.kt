package com.lucaszeta.adventofcode2020.day5

fun calculateSeatId(seatCoordinates: Pair<Int, Int>) =
    seatCoordinates.first * 8 + seatCoordinates.second

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
