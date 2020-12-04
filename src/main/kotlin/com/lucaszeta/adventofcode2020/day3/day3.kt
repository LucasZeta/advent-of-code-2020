package com.lucaszeta.adventofcode2020.day3

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun findTreesForSlope(
    mountain: Mountain,
    slope: Slope
) = mountain.countTrees(slope)

fun multiplyTreeForAllSlopes(
    mountain: Mountain,
    slopes: List<Slope>
) = slopes
    .map { mountain.countTrees(it).toLong() }
    .reduce { acc, element -> acc * element }

fun main() {
    val input = getResourceAsText("/day3/map.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    val mountain = Mountain(input)

    val treeCount = findTreesForSlope(mountain, Slope(3, 1))
    val result = multiplyTreeForAllSlopes(mountain, listOf(
        Slope(1, 1),
        Slope(3, 1),
        Slope(5, 1),
        Slope(7, 1),
        Slope(1, 2)
    ))

    println("Number of trees for slope (3, 1): %d".format(treeCount))
    println("Multiplication of tree for all slopes: %d".format(result))
}
