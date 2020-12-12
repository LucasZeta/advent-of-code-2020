package com.lucaszeta.adventofcode2020.day12

class DirectNavigationSystem(
    private val instructions: List<NavigationalInstruction>
) {

    var currentPositionX = 0
        private set

    var currentPositionY = 0
        private set

    var currentDirection = Direction.EAST

    private val directionDegrees = listOf(
        Direction.EAST to 0,
        Direction.NORTH to 90,
        Direction.WEST to 180,
        Direction.SOUTH to 270,
    )

    fun navigate() {
        instructions.forEach(::executeInstruction)
    }

    private fun executeInstruction(instruction: NavigationalInstruction) {
        when (instruction.direction) {
            Direction.NORTH -> currentPositionY += instruction.units
            Direction.SOUTH -> currentPositionY -= instruction.units
            Direction.EAST -> currentPositionX += instruction.units
            Direction.WEST -> currentPositionX -= instruction.units
            Direction.LEFT -> {
                directionDegrees.find { it.first == currentDirection }?.let { (_, degrees) ->
                    val newDegrees = (degrees + instruction.units).rem(360)

                    directionDegrees.find { it.second == newDegrees }?.let { newDirection ->
                        currentDirection = newDirection.first
                    }
                }
            }
            Direction.RIGHT -> {
                directionDegrees.find { it.first == currentDirection }?.let { (_, degrees) ->
                    var newDegrees = degrees - instruction.units
                    if (newDegrees < 0) {
                        newDegrees += 360
                    }

                    directionDegrees.find { it.second == newDegrees }?.let { newDirection ->
                        currentDirection = newDirection.first
                    }
                }
            }
            Direction.FORWARD -> {
                currentDirection.coordinates?.let { (x, y) ->
                    repeat(instruction.units) {
                        currentPositionX += x
                        currentPositionY += y
                    }
                }
            }
        }
    }
}
