package com.lucaszeta.adventofcode2020.day8

class BootCode(
    private val instructions: List<Instruction>
) {

    private val executedInstructions = mutableListOf<Int>()

    var currentIndex = 0
        private set

    var accumulator = 0
        private set

    fun executeInstruction() {
        val instruction = instructions[currentIndex]

        when (instruction.operator) {
            Operator.ACC -> {
                accumulator += instruction.argument
                currentIndex++
            }
            Operator.JMP -> currentIndex += instruction.argument
            Operator.NOP -> currentIndex++
        }
    }

    fun runProgram() {
        for (instruction in instructions) {
            if (executedInstructions.contains(currentIndex)) {
                break
            } else {
                executedInstructions.add(currentIndex)
            }

            executeInstruction()
        }
    }
}
