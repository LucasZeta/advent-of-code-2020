package com.lucaszeta.adventofcode2020.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class MountainTest {

    @TestFactory
    fun `Should count trees for slope`(): List<DynamicTest> {
        val input = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )

        return listOf(
            Slope(1, 1) to 2,
            Slope(3, 1) to 7,
            Slope(5, 1) to 3,
            Slope(7, 1) to 4,
            Slope(1, 2) to 2
        ).map { (slope, expectedTreeCount) ->
            dynamicTest("Should count trees for slope (${slope.right}, ${slope.down})") {
                val treeCount = Mountain(input).countTrees(slope)

                assertEquals(expectedTreeCount, treeCount)
            }
        }
    }
}
