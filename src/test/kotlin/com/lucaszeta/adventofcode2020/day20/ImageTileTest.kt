package com.lucaszeta.adventofcode2020.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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

    @Test
    fun `Should get tile corners`() {
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

        val expectedCorners = listOf(
            listOf('.', '.', '#', '#', '.', '#', '.', '.', '#', '.'),
            listOf('.', '#', '#', '#', '#', '#', '.', '.', '#', '.'),
            listOf('.', '.', '.', '#', '.', '#', '#', '.', '.', '#'),
            listOf('.', '.', '#', '#', '#', '.', '.', '#', '#', '#')
        )

        val corners = ImageTile(input).findCorners()

        assertEquals(8, corners.size)

        expectedCorners.forEach {
            assertTrue(corners.contains(it))
            assertTrue(corners.contains(it.reversed()))
        }
    }
}
