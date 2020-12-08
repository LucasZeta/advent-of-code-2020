package com.lucaszeta.adventofcode2020.day8

data class Instruction(
    val operator: Operator,
    val argument: Int
) {
    constructor(input: String) : this(
        operator = Operator.valueOf(input.split(" ").first().toUpperCase()),
        argument = input.split(" ").last().toInt()
    )
}

enum class Operator {
    ACC, JMP, NOP
}
