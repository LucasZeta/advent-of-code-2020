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

fun findDangerousIngredients(riskyIngredients: Map<String, MutableSet<String>>): List<String> {
    val ingredients = riskyIngredients.toMutableMap()
    val dangerousList = mutableMapOf<String, String>()

    while (dangerousList.size < ingredients.keys.size) {
        ingredients
            .filter { it.value.size == 1 }
            .forEach { (allergen, ingredient) ->
                val dangerousIngredient = ingredient.first()

                dangerousList[allergen] = dangerousIngredient

                ingredients.forEach {
                    it.value.remove(dangerousIngredient)
                }
            }
    }

    return dangerousList
        .toList()
        .sortedBy { it.first }
        .map { it.second }
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
