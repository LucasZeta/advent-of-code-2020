package com.lucaszeta.adventofcode2020.day13

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import java.lang.IllegalArgumentException

fun main() {
    val (earliestTimestamp, busIds) = parseData(getResourceAsText("/day13/notes.txt"))

    val nearestBus = calculateNearestBusArrival(busIds, earliestTimestamp)

    println("Bus #${nearestBus.first} is going to arrive in ${nearestBus.second} minutes")
    println("Multiplication: ${nearestBus.first * nearestBus.second}")
}

fun calculateNearestBusArrival(busIds: List<Int>, earliestTimestamp: Int) = busIds
    .map { busId ->
        busId to busId - earliestTimestamp.rem(busId)
    }
    .minByOrNull { it.second } ?: throw IllegalArgumentException("Invalid input")

fun parseData(input: String) = input
    .split("\n")
    .filter { it.isNotEmpty() }
    .run {
        val timestamp = first().toInt()
        val busIds = "(\\d+)".toRegex()
            .findAll(last())
            .map { it.groupValues[1].toInt() }
            .toList()

        Pair(timestamp, busIds)
    }
