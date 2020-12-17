package com.lucaszeta.adventofcode2020.day16

fun findInvalidFields(
    nearbyTickets: List<List<Int>>,
    ticketFields: Map<String, List<IntRange>>
): List<Int> {
    val invalidValues = mutableListOf<Int>()

    for (value in nearbyTickets.flatten()) {
        val valid = ticketFields.any {
            value in it.value.first() || value in it.value.last()
        }

        if (!valid) {
            invalidValues.add(value)
        }
    }

    return invalidValues.toList()
}
