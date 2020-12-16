package com.lucaszeta.adventofcode2020.day16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day16KtTest {

    @Test
    fun `Should read ticket fields`() {
        val input = "class: 1-3 or 5-7\n" +
                "row: 6-11 or 33-44\n" +
                "seat: 13-40 or 45-50\n" +
                "\n" +
                "your ticket:\n" +
                "7,1,14\n" +
                "\n" +
                "nearby tickets:\n" +
                "7,3,47\n" +
                "40,4,50\n" +
                "55,2,20\n" +
                "38,6,12"

        val expectedOutput = mapOf(
            "class" to listOf(1..3, 5..7),
            "row" to listOf(6..11, 33..44),
            "seat" to listOf(13..40, 45..50)
        )

        assertEquals(expectedOutput, extractTicketFields(input))
    }
}
