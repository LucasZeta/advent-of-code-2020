package com.lucaszeta.adventofcode2020.day18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day18KtTest {

    @Test
    fun `Should evaluate expression from left to right`() {
        assertEquals(71, evaluateExpression("1+2*3+4*5+6"))
    }
}