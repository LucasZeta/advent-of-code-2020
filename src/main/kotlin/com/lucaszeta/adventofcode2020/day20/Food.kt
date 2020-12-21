package com.lucaszeta.adventofcode2020.day20

class Food(input: String) {

    val ingredients: List<String>
    val allergens: List<String>

    init {
        val (ingredientList, allergenList) = input.split(SEPARATOR)
        
        ingredients = INGREDIENTS_PATTERN
            .findAll(ingredientList)
            .map { it.groupValues[1] }
            .toList()

        allergens = ALLERGENS_PATTERN
            .findAll(allergenList)
            .map { it.groupValues[1] }
            .toList()
    }

    companion object {
        val INGREDIENTS_PATTERN = "([a-z]+)".toRegex()
        val ALLERGENS_PATTERN = "([a-z]+)[,)]".toRegex()
        const val SEPARATOR = " (contains"
    }
}
