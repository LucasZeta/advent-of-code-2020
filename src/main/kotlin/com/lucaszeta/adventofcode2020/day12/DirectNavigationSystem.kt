package com.lucaszeta.adventofcode2020.day12

class DirectNavigationSystem(
    instructions: List<NavigationalInstruction>
) : NavigationSystem(instructions) {

    var currentDirection = Direction.EAST

    override fun executeInstruction(instruction: NavigationalInstruction) {
        when (instruction.direction) {
            Direction.NORTH -> currentPositionY += instruction.units
            Direction.SOUTH -> currentPositionY -= instruction.units
            Direction.EAST -> currentPositionX += instruction.units
            Direction.WEST -> currentPositionX -= instruction.units
            Direction.LEFT -> {
                var directionIndex = directions.indexOf(currentDirection)
                directionIndex = (directionIndex + instruction.units / 90).rem(directions.size)

                currentDirection = directions[directionIndex]
            }
            Direction.RIGHT -> {
                var directionIndex = directions.indexOf(currentDirection)

                directionIndex -= instruction.units / 90
                if (directionIndex < 0) {
                    directionIndex += directions.size
                }

                currentDirection = directions[directionIndex]
            }
            Direction.FORWARD -> {
                val coordinates = when (currentDirection) {
                    Direction.EAST -> 1 to 0
                    Direction.NORTH -> 0 to 1
                    Direction.WEST -> -1 to 0
                    else -> 0 to -1
                }

                currentPositionX += coordinates.first * instruction.units
                currentPositionY += coordinates.second * instruction.units
            }
        }
    }

    companion object {
        val directions = listOf(
            Direction.EAST,
            Direction.NORTH,
            Direction.WEST,
            Direction.SOUTH
        )
    }
}
