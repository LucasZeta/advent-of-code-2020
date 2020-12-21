package com.lucaszeta.adventofcode2020.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day20KtTest {

    @Test
    fun `Should find ingredients that appear in allergen list`() {
        val input = listOf(
            "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
            "trh fvjkl sbzzf mxmxvkd (contains dairy)",
            "sqjhc fvjkl (contains soy)",
            "sqjhc mxmxvkd sbzzf (contains fish)"
        ).map(::Food)

        val expectedOutput = setOf("mxmxvkd", "sqjhc", "fvjkl")

        assertEquals(expectedOutput, findRiskyIngredients(input))
    }
}
