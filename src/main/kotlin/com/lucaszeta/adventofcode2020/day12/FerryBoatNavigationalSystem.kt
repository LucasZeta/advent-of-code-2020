package com.lucaszeta.adventofcode2020.day12

class FerryBoatNavigationalSystem(
    private val instructions: List<NavigationalInstruction>
) {

    var currentPositionX = 0
        private set

    var currentPositionY = 0
        private set

    fun navigate() {
        for (instruction in instructions) {
            executeInstruction(instruction)
        }
    }

    fun executeInstruction(instruction: NavigationalInstruction) {
        when (instruction.direction) {
            Direction.NORTH -> currentPositionY += instruction.units
            Direction.SOUTH -> currentPositionY -= instruction.units
            Direction.EAST -> currentPositionX += instruction.units
            Direction.WEST -> currentPositionX -= instruction.units
        }
    }
}
