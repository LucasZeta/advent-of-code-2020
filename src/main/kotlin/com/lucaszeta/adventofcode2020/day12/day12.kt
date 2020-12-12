package com.lucaszeta.adventofcode2020.day12

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlin.math.abs

fun main() {
    val instructions = getResourceAsText("/day12/navigation-instructions.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map(::NavigationalInstruction)

    val navigationalSystem = FerryBoatNavigationalSystem(instructions)
    val waypointNavigationalSystem = FerryBoatWaypointNavigationalSystem(instructions, 10, 1)

    navigationalSystem.navigate()
    waypointNavigationalSystem.navigate()

    val distance = calculateManhattanDistance(
        navigationalSystem.currentPositionX,
        navigationalSystem.currentPositionY,
        0,
        0
    )

    val distanceWithWaypoint = calculateManhattanDistance(
        waypointNavigationalSystem.currentPositionX,
        waypointNavigationalSystem.currentPositionY,
        0,
        0
    )

    println("Distance from origin: $distance")
    println("Real distance from origin: $distanceWithWaypoint")
}

fun calculateManhattanDistance(
    currentX: Int,
    currentY: Int,
    originX: Int,
    originY: Int
) = abs(currentX - originX) + abs(currentY - originY)
