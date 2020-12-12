package com.lucaszeta.adventofcode2020.day12

class WaypointNavigationSystem(
    private val instructions: List<NavigationalInstruction>,
    var waypointX: Int,
    var waypointY: Int
) {

    var currentPositionX = 0
        private set

    var currentPositionY = 0
        private set

    fun navigate() {
        instructions.forEach(::executeInstruction)
    }

    private fun executeInstruction(instruction: NavigationalInstruction) {
        when (instruction.direction) {
            Direction.NORTH -> waypointY += instruction.units
            Direction.SOUTH -> waypointY -= instruction.units
            Direction.EAST -> waypointX += instruction.units
            Direction.WEST -> waypointX -= instruction.units
            Direction.LEFT -> {
                repeat(instruction.units / 90) {
                    val temporary = waypointX
                    waypointX = -waypointY
                    waypointY = temporary
                }
            }
            Direction.RIGHT -> {
                repeat(instruction.units / 90) {
                    val temporary = waypointX
                    waypointX = waypointY
                    waypointY = -temporary
                }
            }
            Direction.FORWARD -> {
                repeat(instruction.units) {
                    currentPositionX += waypointX
                    currentPositionY += waypointY
                }
            }
        }
    }
}
