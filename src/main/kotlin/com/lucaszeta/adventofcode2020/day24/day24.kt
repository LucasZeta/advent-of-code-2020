package com.lucaszeta.adventofcode2020.day24

const val BLACK = '#'
const val WHITE = '.'

fun flipTiles(
    directionsList: List<List<Direction>>
): Map<Pair<Double, Double>, Char> {
    val tiles = mutableMapOf<Pair<Double, Double>, Char>()

    for (directions in directionsList) {
        val destination = navigateToTile(directions)

        tiles[destination] = if (tiles.containsKey(destination)) WHITE else BLACK
    }

    return tiles.toMap()
}

fun navigateToTile(directions: List<Direction>): Pair<Double, Double> {
    var coordinateX = 0.0
    var coordinateY = 0.0

    directions.forEach {
        coordinateY += when (it) {
            Direction.NORTHEAST,
            Direction.NORTHWEST -> 1.0
            Direction.SOUTHEAST,
            Direction.SOUTHWEST -> -1.0
            else -> 0.0
        }

        coordinateX += when (it) {
            Direction.NORTHEAST,
            Direction.SOUTHEAST -> 0.5
            Direction.NORTHWEST,
            Direction.SOUTHWEST -> -0.5
            Direction.EAST -> 1.0
            Direction.WEST -> -1.0
        }
    }

    return coordinateX to coordinateY
}

fun parseToDirections(line: String): List<Direction> {
    val directionsRegex = run {
        val allDirections = Direction.allDirections().joinToString("|")

        "($allDirections)".toRegex()
    }

    return directionsRegex.findAll(line)
        .map { Direction.fromCoordinate(it.groupValues[1]) }
        .toList()
}
