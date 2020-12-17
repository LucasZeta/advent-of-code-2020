package com.lucaszeta.adventofcode2020.day16

fun identifyFieldIndex(
    nearbyTickets: List<List<Int>>,
    ticketFields: Map<String, List<IntRange>>
): Map<String, Int> {
    val possibilities = findPossibleIndexesForFields(nearbyTickets, ticketFields)

    val resultMap = mutableMapOf<String, Int>()

    while (resultMap.size < ticketFields.size) {
        val fieldsThatCanOnlyBeInOnePlace = possibilities.filterValues { it.size == 1 }

        for (field in fieldsThatCanOnlyBeInOnePlace) {
            val index = field.value.first()

            resultMap[field.key] = index

            possibilities.forEach {
                it.value.remove(index)
            }
        }
    }

    return resultMap
}

fun filterValidTickets(
    nearbyTickets: List<List<Int>>,
    ticketFields: Map<String, List<IntRange>>
) = nearbyTickets.filter { nearbyTicket ->
    for (value in nearbyTicket) {
        val valid = ticketFields.any {
            value in it.value.first() || value in it.value.last()
        }

        if (!valid) {
            return@filter false
        }
    }

    return@filter true
}

private fun findPossibleIndexesForFields(
    nearbyTickets: List<List<Int>>,
    ticketFields: Map<String, List<IntRange>>
): MutableMap<String, MutableSet<Int>> {
    val possibilities = mutableMapOf<String, MutableSet<Int>>()

    for (ticketField in ticketFields) {
        val possibleIndexes = nearbyTickets
            .map { nearbyTicket ->
                val matchingIndexes = mutableSetOf<Int>()

                nearbyTicket.forEachIndexed { index, value ->
                    if (value in ticketField.value.first() || value in ticketField.value.last()) {
                        matchingIndexes.add(index)
                    }
                }

                return@map matchingIndexes
            }
            .filterNot { it.isEmpty() }
            .reduce { accumulator, currentIndexes ->
                accumulator.intersect(currentIndexes).toMutableSet()
            }

        possibilities[ticketField.key] = possibleIndexes
    }

    return possibilities
}
