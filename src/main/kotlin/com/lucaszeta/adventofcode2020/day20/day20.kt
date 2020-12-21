package com.lucaszeta.adventofcode2020.day20

fun findRiskyIngredients(foodList: List<Food>): Set<String> {
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

    return riskyIngredients.flatMap { it.value }.toSet()
}
