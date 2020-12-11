package com.lucaszeta.adventofcode2020.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TobogganTest {

    @Test
    fun `Should start at the upper left part of the map`() {
        val toboggan = Toboggan(10)

        assertEquals(0, toboggan.x)
        assertEquals(0, toboggan.y)
    }

    @Test
    fun `Should apply slope`() {
        val slope = Slope(3, 2)
        val toboggan = Toboggan(10)

        toboggan.goToNextPosition(slope)

        assertEquals(3, toboggan.x)
        assertEquals(2, toboggan.y)

        toboggan.goToNextPosition(slope)

        assertEquals(6, toboggan.x)
        assertEquals(4, toboggan.y)
    }

    @Test
    fun `Should reset x coordinate when reaching map width`() {
        val slope = Slope(3, 2)
        val toboggan = Toboggan(6)

        toboggan.goToNextPosition(slope)

        assertEquals(3, toboggan.x)
        assertEquals(2, toboggan.y)

        toboggan.goToNextPosition(slope)

        assertEquals(0, toboggan.x)
        assertEquals(4, toboggan.y)
    }
}
