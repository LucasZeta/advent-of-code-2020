package com.lucaszeta.adventofcode2020.day8

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val instructions = getResourceAsText("/day8/boot-code.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map(::Instruction)

    val bootCode = BootCode(instructions).apply {
        runProgram()
    }

    println("Last value before repeated instruction: ${bootCode.accumulator}")
}

fun fixInstructions(instructions: List<Instruction>): List<Instruction> {
    var newInstructions = mutableListOf<Instruction>()

    do {
        var exitedSuccessfully = false

        instructions.forEachIndexed { index, instruction ->
            if (instruction.operator == Operator.NOP || instruction.operator == Operator.JMP) {
                val newInstruction = instruction.copy(
                    operator = if (instruction.operator == Operator.NOP) Operator.JMP else Operator.NOP
                )

                newInstructions = instructions.toMutableList().apply {
                    set(index, newInstruction)
                }

                exitedSuccessfully = BootCode(newInstructions.toList()).runProgram()
            }
        }
    } while (!exitedSuccessfully)

    return newInstructions.toList()
}
