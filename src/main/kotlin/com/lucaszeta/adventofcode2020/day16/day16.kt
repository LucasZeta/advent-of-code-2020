package com.lucaszeta.adventofcode2020.day16

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val input = getResourceAsText("/day16/ticket-notes.txt")

    val ticketFields = extractTicketFields(input)
    val myTicket = extractYourTicket(input)
    val nearbyTickets = extractNearbyTickets(input)

    val invalidValues = findInvalidFields(nearbyTickets, ticketFields)

    println("Ticket scanning error rate: ${invalidValues.reduce(Int::plus)}")
}

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

fun extractYourTicket(input: String): List<Int> {
    val lines = input.split("\n")
    val index = lines.indexOf("your ticket:")

    return lines[index + 1].split(",").map { it.toInt() }
}

fun extractNearbyTickets(input: String): List<List<Int>> {
    val lines = input.split("\n")
    val index = lines.indexOf("nearby tickets:")
    val nearbyTickets = mutableListOf<List<Int>>()

    for (i in (index + 1) until lines.size) {
        if (lines[i].isNotEmpty()) {
            nearbyTickets.add(lines[i].split(",").map { it.toInt() })
        }
    }

    return nearbyTickets.toList()
}

fun extractTicketFields(input: String): Map<String, List<IntRange>> {
    val ticketFieldResult = "([a-z ]*): (\\d+)-(\\d+) or (\\d+)-(\\d+)"
        .toRegex()
        .findAll(input)

    val ticketFields = mutableMapOf<String, List<IntRange>>()

    ticketFieldResult.forEach {
        val name = it.groupValues[1]
        val firstRange = it.groupValues[2].toInt()..it.groupValues[3].toInt()
        val secondRange = it.groupValues[4].toInt()..it.groupValues[5].toInt()

        ticketFields[name] = listOf(firstRange, secondRange)
    }

    return ticketFields.toMap()
}

private fun findPossibleIndexesForFields(
    nearbyTickets: List<List<Int>>,
    ticketFields: Map<String, List<IntRange>>
): MutableMap<String, MutableSet<Int>> {
    val possibilities = mutableMapOf<String, MutableSet<Int>>()
    val breadth = nearbyTickets.first().size

    for (ticketField in ticketFields) {
        var possibleIndexes = (0 until breadth).toSet()

        for (nearbyTicket in nearbyTickets) {
            val matchingIndexes = mutableSetOf<Int>()

            nearbyTicket.forEachIndexed { index, value ->
                if (value in ticketField.value.first() || value in ticketField.value.last()) {
                    matchingIndexes.add(index)
                }
            }

            possibleIndexes = possibleIndexes.intersect(matchingIndexes)
        }

        possibilities[ticketField.key] = possibleIndexes.toMutableSet()
    }

    return possibilities
}
