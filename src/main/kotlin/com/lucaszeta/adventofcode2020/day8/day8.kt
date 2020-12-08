package com.lucaszeta.adventofcode2020.day8

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

fun main() {
    val instructions = getResourceAsText("/day8/boot-code.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map(::Instruction)

    val bootCode = BootCode(instructions).apply { runProgram() }
    println("Last value before infinite loop: ${bootCode.accumulator}")

    val newInstructions = fixInstructions(instructions)
    val secondBootCode = BootCode(newInstructions).apply { runProgram() }
    println("True last value: ${secondBootCode.accumulator}")
}

fun fixInstructions(instructions: List<Instruction>) = runBlocking(Dispatchers.Default) {

    val result = instructions.mapIndexed { index, instruction ->
        async {
            if (instruction.operator == Operator.NOP || instruction.operator == Operator.JMP) {
                val newInstruction = instruction.copy(
                    operator = if (instruction.operator == Operator.NOP) Operator.JMP else Operator.NOP
                )

                val newInstructions = instructions.toMutableList().apply {
                    set(index, newInstruction)
                }.toList()

                if (BootCode(newInstructions).runProgram()) {
                    return@async newInstructions
                }
            }

            listOf<Instruction>()
        }
    }.awaitAll()

    result.flatten()
}
