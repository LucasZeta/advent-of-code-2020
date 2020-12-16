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
