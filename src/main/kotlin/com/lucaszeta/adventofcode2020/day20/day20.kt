package com.lucaszeta.adventofcode2020.day20

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val foodList = getResourceAsText("/day20/food-list.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map(::Food)

    val riskyIngredients = findRiskyIngredients(foodList)
    val riskyIngredientsName = riskyIngredients.flatMap { it.value }.toSet()

    val safeIngredients = findSafeIngredients(foodList, riskyIngredientsName)

    println("Safe ingredients count: ${safeIngredients.size}")
}

fun findRiskyIngredients(foodList: List<Food>): Map<String, MutableSet<String>> {
    val riskyIngredients = mutableMapOf<String, MutableSet<String>>()

    for (food in foodList) {
        food.allergens.forEach { allergen ->
            if (riskyIngredients.containsKey(allergen)) {
                val commonIngredients = riskyIngredients
                    .getValue(allergen)
                    .intersect(food.ingredients)

                riskyIngredients[allergen] = commonIngredients.toMutableSet()
            } else {
                riskyIngredients[allergen] = food.ingredients.toMutableSet()
            }
        }
    }

    return riskyIngredients.toMap()
}

fun findSafeIngredients(
    foodList: List<Food>,
    riskyIngredients: Set<String>
) = foodList
    .flatMap { it.ingredients }
    .filterNot { riskyIngredients.contains(it) }
