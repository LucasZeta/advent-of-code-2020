package com.lucaszeta.adventofcode2020.day24

fun parseToDirections(line: String): List<Direction> {
    val directionsRegex = run {
        val allDirections = Direction.allDirections().joinToString("|")

        "($allDirections)".toRegex()
    }

    return directionsRegex.findAll(line)
        .map { Direction.fromCoordinate(it.groupValues[1]) }
        .toList()
}
