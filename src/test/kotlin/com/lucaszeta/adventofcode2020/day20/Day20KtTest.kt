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

        val expectedOutput = mapOf(
            "dairy" to setOf("mxmxvkd"),
            "fish" to setOf("mxmxvkd", "sqjhc"),
            "soy" to setOf("sqjhc", "fvjkl")
        )

        assertEquals(expectedOutput, findRiskyIngredients(input))
    }

    @Test
    fun `Should find ingredients that are not in the risky list`() {
        val foodList = listOf(
            "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
            "trh fvjkl sbzzf mxmxvkd (contains dairy)",
            "sqjhc fvjkl (contains soy)",
            "sqjhc mxmxvkd sbzzf (contains fish)"
        ).map(::Food)

        val riskyIngredients = setOf("mxmxvkd", "sqjhc", "fvjkl")

        val expectedOutput = listOf("kfcds", "nhms", "trh", "sbzzf", "sbzzf")

        assertEquals(expectedOutput, findSafeIngredients(foodList, riskyIngredients))
    }

    @Test
    fun `Should determine which risky ingredients are the dangerous ones`() {
        val riskyIngredients = mapOf(
            "dairy" to mutableSetOf("mxmxvkd"),
            "fish" to mutableSetOf("mxmxvkd", "sqjhc"),
            "soy" to mutableSetOf("sqjhc", "fvjkl")
        )

        val expectedOutput = listOf("mxmxvkd", "sqjhc", "fvjkl")

        assertEquals(expectedOutput, findDangerousIngredients(riskyIngredients))
    }
}
