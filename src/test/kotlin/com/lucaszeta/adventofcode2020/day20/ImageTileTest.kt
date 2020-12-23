package com.lucaszeta.adventofcode2020.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImageTileTest {

    @Test
    fun `Should map input data`() {
        val input = "Tile 2311:\n" +
                "..##.#..#.\n" +
                "##..#.....\n" +
                "#...##..#.\n" +
                "####.#...#\n" +
                "##.##.###.\n" +
                "##...#.###\n" +
                ".#.#.#..##\n" +
                "..#....#..\n" +
                "###...#.#.\n" +
                "..###..###"

        val expectedGrid = listOf(
            listOf('.', '.', '#', '#', '.', '#', '.', '.', '#', '.'),
            listOf('#', '#', '.', '.', '#', '.', '.', '.', '.', '.'),
            listOf('#', '.', '.', '.', '#', '#', '.', '.', '#', '.'),
            listOf('#', '#', '#', '#', '.', '#', '.', '.', '.', '#'),
            listOf('#', '#', '.', '#', '#', '.', '#', '#', '#', '.'),
            listOf('#', '#', '.', '.', '.', '#', '.', '#', '#', '#'),
            listOf('.', '#', '.', '#', '.', '#', '.', '.', '#', '#'),
            listOf('.', '.', '#', '.', '.', '.', '.', '#', '.', '.'),
            listOf('#', '#', '#', '.', '.', '.', '#', '.', '#', '.'),
            listOf('.', '.', '#', '#', '#', '.', '.', '#', '#', '#')
        )

        val tile = ImageTile(input)

        assertEquals(2311L, tile.id)
        assertEquals(expectedGrid, tile.grid)
    }
}
