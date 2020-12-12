package com.lucaszeta.adventofcode2020.day12

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlin.math.abs

fun main() {
    val instructions = getResourceAsText("/day12/navigation-instructions.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map(::NavigationalInstruction)

    val boatInitialPosition = 0 to 0
    val waypoint = 10 to 1

    val navigationalSystem = DirectNavigationSystem(instructions)
    val waypointNavigationalSystem = WaypointNavigationSystem(
        instructions,
        waypoint.first,
        waypoint.second
    )

    navigationalSystem.navigate()
    waypointNavigationalSystem.navigate()

    val distance = calculateManhattanDistance(
        navigationalSystem.currentPositionX,
        navigationalSystem.currentPositionY,
        boatInitialPosition.first,
        boatInitialPosition.second
    )

    val distanceWithWaypoint = calculateManhattanDistance(
        waypointNavigationalSystem.currentPositionX,
        waypointNavigationalSystem.currentPositionY,
        boatInitialPosition.first,
        boatInitialPosition.second
    )

    println("Distance from origin based on direct navigation: $distance")
    println("Real distance from origin: $distanceWithWaypoint")
}

fun calculateManhattanDistance(
    currentX: Int,
    currentY: Int,
    originX: Int,
    originY: Int
) = abs(currentX - originX) + abs(currentY - originY)
