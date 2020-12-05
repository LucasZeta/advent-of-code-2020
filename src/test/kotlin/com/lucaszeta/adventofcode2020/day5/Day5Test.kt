package com.lucaszeta.adventofcode2020.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun `Should calculate seat ID`() {
        assertEquals(567, calculateSeatId(70 to 7))
        assertEquals(119, calculateSeatId(14 to 7))
        assertEquals(820, calculateSeatId(102 to 4))
    }
}
