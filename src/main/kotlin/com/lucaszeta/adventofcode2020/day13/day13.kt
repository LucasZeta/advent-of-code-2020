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

fun calculateSequentialBusDepartures(buses: List<Bus>): Long {
    var earliestTimestamp = 0L
    var accumulator = 0L

    for ((index, bus) in buses.dropLast(1).withIndex()) {
        var multiplier = 1
        val nextBus = buses[index + 1]

        while (true) {
            val timestamp = if (index == 0) {
                bus.id * multiplier
            } else {
                earliestTimestamp + accumulator * multiplier
            }

            if ((timestamp + nextBus.offset).rem(nextBus.id) == 0L) {
                earliestTimestamp = timestamp

                if (index < buses.size - 2) {
                    accumulator = buses
                        .slice(0..(index + 1))
                        .map { it.id }
                        .reduce(::leastCommonMultiplier)
                }
                break
            }

            multiplier++
        }
    }

    return earliestTimestamp
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

fun parseAllBusIdData(input: List<String>) = input.last()
    .split(",")
    .mapIndexed { index, stringValue ->
        if (stringValue != "x") {
            Bus(stringValue.toLong(), index)
        } else {
            null
        }
    }
    .filterNotNull()

private fun leastCommonMultiplier(number1: Long, number2: Long): Long {
    var a = number1
    var b = number2

    while (a != b) {
        if (a > b) {
            a -= b
        } else {
            b -= a
        }
    }

    return number1 * number2 / a
}
