package com.lucaszeta.adventofcode2020.day3

fun main() {
    val trees = Mountain(input)
        .countTrees(Slope(3, 1))

    println(trees)
}
