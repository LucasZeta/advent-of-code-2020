package com.lucaszeta.adventofcode2020.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day03KtTest {

    private lateinit var mountain: Mountain

    @BeforeEach
    fun setup() {
        mountain = Mountain(
            listOf(
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
        )
    }

    @Test
    fun `Should count trees for slope (3, 1)`() {
        assertEquals(7, findTreesForSlope(mountain, Slope(3, 1)))
    }

    @Test
    fun `Should multiply tree count for slopes`() {
        assertEquals(
            336,
            multiplyTreeForAllSlopes(
                mountain,
                listOf(
                    Slope(1, 1),
                    Slope(3, 1),
                    Slope(5, 1),
                    Slope(7, 1),
                    Slope(1, 2)
                )
            )
        )
    }
}
