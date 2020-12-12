package com.lucaszeta.adventofcode2020.day12

abstract class NavigationSystem(
    private val instructions: List<NavigationalInstruction>
) {

    var currentPositionX = 0
        protected set

    var currentPositionY = 0
        protected set

    fun navigate(boatPosition: Pair<Int, Int> = 0 to 0) {
        currentPositionX = boatPosition.first
        currentPositionY = boatPosition.second

        instructions.forEach(::executeInstruction)
    }

    protected abstract fun executeInstruction(instruction: NavigationalInstruction)
}
