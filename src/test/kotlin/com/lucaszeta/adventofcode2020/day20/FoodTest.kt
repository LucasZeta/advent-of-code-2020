package com.lucaszeta.adventofcode2020.day20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FoodTest {

    @Test
    fun `Should map input data`() {
        val expectedIngredients = listOf("mxmxvkd", "kfcds", "sqjhc", "nhms")
        val expectedAllergens = listOf("dairy", "fish")

        val food = Food("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)")

        assertEquals(expectedIngredients, food.ingredients)
        assertEquals(expectedAllergens, food.allergens)
    }
}
