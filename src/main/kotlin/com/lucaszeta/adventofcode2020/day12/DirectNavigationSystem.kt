package com.lucaszeta.adventofcode2020.day12

class DirectNavigationSystem(
    private val instructions: List<NavigationalInstruction>
) {

    var currentPositionX = 0
        private set

    var currentPositionY = 0
        private set

    var currentDirection = Direction.EAST

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
                currentDirection.coordinates?.let { (x, y) ->
                    repeat(instruction.units) {
                        currentPositionX += x
                        currentPositionY += y
                    }
                }
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
