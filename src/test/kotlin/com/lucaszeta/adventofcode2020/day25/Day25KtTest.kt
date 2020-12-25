package com.lucaszeta.adventofcode2020.day25

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day25KtTest {

    @Test
    fun `Should discover loop size`() {
        assertEquals(8, findLoopSize(5764801, 7))
        assertEquals(11, findLoopSize(17807724, 7))
    }
}
