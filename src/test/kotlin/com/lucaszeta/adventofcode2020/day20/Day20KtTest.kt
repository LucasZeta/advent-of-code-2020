package com.lucaszeta.adventofcode2020.day20

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day20KtTest {

    @Test
    fun `Should find corner tiles`() {
        val tiles = getResourceAsText("/day20/sample-tiles.txt")
            .split("\n\n")
            .map(::ImageTile)

        val corners = findCornerTiles(tiles).toMap()

        assertEquals(4, corners.size)
        assertTrue(corners.containsKey(1951))
        assertTrue(corners.containsKey(3079))
        assertTrue(corners.containsKey(2971))
        assertTrue(corners.containsKey(1171))
    }
}
