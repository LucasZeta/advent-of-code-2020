package com.lucaszeta.adventofcode2020.day24

enum class Direction(val coordinate: String) {
    NORTHWEST("nw"),
    WEST("w"),
    SOUTHWEST("sw"),
    SOUTHEAST("se"),
    EAST("e"),
    NORTHEAST("ne");

    companion object {

        fun fromCoordinate(coordinate: String) = values()
            .find { it.coordinate == coordinate }
            ?: throw IllegalArgumentException("Invalid coordinate")

        fun allDirections() = values()
            .map { it.coordinate }
            .toList()
    }
}
