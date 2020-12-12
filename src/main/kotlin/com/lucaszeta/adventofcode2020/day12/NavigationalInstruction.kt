package com.lucaszeta.adventofcode2020.day12

import java.lang.IllegalArgumentException

data class NavigationalInstruction(
    val direction: Direction,
    val units: Int
) {
    constructor(input: String) : this(
        direction = Direction.fromKey(input.take(1).toUpperCase()),
        units = input.drop(1).toInt()
    )
}

enum class Direction(val key: String) {
    NORTH("N",),
    SOUTH("S"),
    EAST("E"),
    WEST("W"),
    LEFT("L"),
    RIGHT("R"),
    FORWARD("F");

    companion object {

        fun fromKey(searchKey: String): Direction {
            return values().find { it.key == searchKey }
                ?: throw IllegalArgumentException("Invalid direction key")
        }
    }
}
