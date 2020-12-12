package com.lucaszeta.adventofcode2020.day12

class FerryBoatWaypointNavigationalSystem(
    private val instructions: List<NavigationalInstruction>,
    var waypointX: Int,
    var waypointY: Int
) {

    fun navigate() {
        instructions.forEach(::executeInstruction)
    }

    private fun executeInstruction(instruction: NavigationalInstruction) {
        when (instruction.direction) {
            Direction.NORTH -> waypointY += instruction.units
            Direction.SOUTH -> waypointY -= instruction.units
            Direction.EAST -> waypointX += instruction.units
            Direction.WEST -> waypointX -= instruction.units
        }
    }
}
