package com.lucaszeta.adventofcode2020.day18

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day18KtTest {

    @Test
    fun `Should evaluate expression from left to right`() {
        assertEquals(71L, evaluateExpression("1 + 2 * 3 + 4 * 5 + 6"))
    }

    @Test
    fun `Should evaluate expression considering parenthesis`() {
        assertEquals(51L, evaluateExpression("1 + (2 * 3) + (4 * (5 + 6))"))
    }

    @Test
    fun `Should evaluate sample data`() {
        listOf(
            "2 * 3 + (4 * 5)" to 26L,
            "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 437L,
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 12240L,
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 13632L
        ).forEach { (input, expectedOutput) ->
            assertEquals(expectedOutput, evaluateExpression(input))
        }
    }

    @Test
    fun `Should evaluate expression giving precedence to sum over multiplication`() {
        assertEquals(231L, evaluateAdvancedMathExpression("1 + 2 * 3 + 4 * 5 + 6"))
    }

    @Test
    fun `Should evaluate sample data based on Advanced Math rules`() {
        listOf(
            "2 * 3 + (4 * 5)" to 46L,
            "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 1445L,
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 669060L,
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 23340L
        ).forEach { (input, expectedOutput) ->
            assertEquals(expectedOutput, evaluateAdvancedMathExpression(input))
        }
    }
}
