package com.lucaszeta.adventofcode2020.day5

fun calculateSeatId(seatCoordinates: Pair<Int, Int>) =
    seatCoordinates.first * 8 + seatCoordinates.second
