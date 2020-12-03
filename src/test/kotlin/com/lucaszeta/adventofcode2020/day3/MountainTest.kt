package com.lucaszeta.adventofcode2020.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MountainTest {

    @Test
    fun `Should count trees for slope (3, 1)`() {
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

        assertEquals(7, Mountain(input).countTrees(Slope(3, 1)))
    }
}
