package com.lucaszeta.adventofcode2020.day12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day12KtTest {

    @Test
    fun `Should calculate distance between origin and current position`() {
        assertEquals(25, calculateManhattanDistance(17, -8, 0, 0))
    }
}
