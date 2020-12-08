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
