package com.lucaszeta.adventofcode2020.day12

abstract class NavigationSystem(
    private val instructions: List<NavigationalInstruction>
) {

    var currentPositionX = 0
        protected set

    var currentPositionY = 0
        protected set

    fun navigate() {
        instructions.forEach(::executeInstruction)
    }

    protected abstract fun executeInstruction(instruction: NavigationalInstruction)
}
