package com.lucaszeta.adventofcode2020.day21

class Food(input: String) {

    val ingredients: List<String>
    val allergens: List<String>

    init {
        val (ingredientList, allergenList) = input.split(SEPARATOR)

        ingredients = fetchContentsFromString(INGREDIENTS_PATTERN, ingredientList)
        allergens = fetchContentsFromString(ALLERGENS_PATTERN, allergenList)
    }

    private fun fetchContentsFromString(pattern: Regex, text: String) = pattern
        .findAll(text)
        .map { it.groupValues[1] }
        .toList()

    companion object {
        val INGREDIENTS_PATTERN = "([a-z]+)".toRegex()
        val ALLERGENS_PATTERN = "([a-z]+)[,)]".toRegex()
        const val SEPARATOR = " (contains"
    }
}
