package com.lucaszeta.adventofcode2020.day16

fun extractYourTicket(input: String): List<Int> {
    val lines = input.split("\n")
    val index = lines.indexOf("your ticket:")

    return lines[index + 1].split(",").map { it.toInt() }
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
