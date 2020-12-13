package com.lucaszeta.adventofcode2020.day13

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import java.lang.IllegalArgumentException

fun main() {
    val input = getResourceAsText("/day13/notes.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
    val (earliestTimestamp, busIds) = parseValidBusIdData(input)

    val nearestBus = calculateNearestBusArrival(busIds, earliestTimestamp)

    println("Bus #${nearestBus.first} is going to arrive in ${nearestBus.second} minutes")
    println("Multiplication: ${nearestBus.first * nearestBus.second}")
}

fun calculateSequentialBusDepartures(allBusIds: List<Long>): Long {
    val biggestBusId = allBusIds.maxOrNull() ?: throw IllegalArgumentException("Invalid input")
    val biggestBusIdIndex = allBusIds.indexOf(biggestBusId)
    var multiplier = 1

    while (true) {
        val timestamp = biggestBusId * multiplier
        var found = true

        for ((index, otherBusId) in allBusIds.withIndex()) {
            if (otherBusId == 1L) continue
            if (index == biggestBusIdIndex) continue

            if ((timestamp + index - biggestBusIdIndex).rem(otherBusId) != 0L) {
                found = false
                break
            }
        }

        if (found) {
            return timestamp - biggestBusIdIndex
        }

        multiplier++
    }
}

fun calculateNearestBusArrival(busIds: List<Int>, earliestTimestamp: Int) = busIds
    .map { busId ->
        busId to busId - earliestTimestamp.rem(busId)
    }
    .minByOrNull { it.second } ?: throw IllegalArgumentException("Invalid input")

fun parseValidBusIdData(input: List<String>) = input.run {
    val timestamp = first().toInt()
    val busIds = "(\\d+)".toRegex()
        .findAll(last())
        .map { it.groupValues[1].toInt() }
        .toList()

    Pair(timestamp, busIds)
}
