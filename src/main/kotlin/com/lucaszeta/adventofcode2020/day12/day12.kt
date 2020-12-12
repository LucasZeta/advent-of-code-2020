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

    val directNavigationSystem = DirectNavigationSystem(instructions)
    val waypointNavigationalSystem = WaypointNavigationSystem(
        instructions,
        waypoint.first,
        waypoint.second
    )

    displayDistance(
        directNavigationSystem,
        boatInitialPosition,
        "Distance from origin based on direct navigation"
    )

    displayDistance(
        waypointNavigationalSystem,
        boatInitialPosition,
        "Real distance from origin"
    )
}

fun calculateManhattanDistance(
    currentX: Int,
    currentY: Int,
    originX: Int,
    originY: Int
) = abs(currentX - originX) + abs(currentY - originY)

private fun displayDistance(
    navigationSystem: NavigationSystem,
    boatInitialPosition: Pair<Int, Int>,
    messageLabel: String
) {
    navigationSystem.navigate(boatInitialPosition)

    val distance = calculateManhattanDistance(
        navigationSystem.currentPositionX,
        navigationSystem.currentPositionY,
        boatInitialPosition.first,
        boatInitialPosition.second
    )

    println("$messageLabel: $distance")
}
