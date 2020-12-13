package com.lucaszeta.adventofcode2020.day13

import com.lucaszeta.adventofcode2020.ext.getResourceAsText
import java.lang.IllegalArgumentException

fun main() {
    val input = getResourceAsText("/day13/notes.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
    val (earliestTimestamp, buses) = parseBusData(input)

    val nearestBus = calculateNearestBusArrival(buses, earliestTimestamp)

    println("Bus #${nearestBus.first} is going to arrive in ${nearestBus.second} minutes")
    println("Multiplication: ${nearestBus.first * nearestBus.second}")

    val sequentialBusDeparture = calculateSequentialBusDepartures(buses)
    println("Earliest sequential bus departure: $sequentialBusDeparture")
}

fun calculateSequentialBusDepartures(buses: List<Bus>): Long {
    var earliestTimestamp = 0L
    var accumulator = buses.first().id

    for (index in 0 until buses.size - 1) {
        var multiplier = 1
        val nextBus = buses[index + 1]

        while (true) {
            val timestamp = earliestTimestamp + accumulator * multiplier

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

fun calculateNearestBusArrival(buses: List<Bus>, earliestTimestamp: Int) = buses
    .map { bus -> bus.id to bus.id - earliestTimestamp.rem(bus.id) }
    .minByOrNull { it.second }
    ?: throw IllegalArgumentException("Invalid input")

fun parseBusData(input: List<String>) = input.run {
    val timestamp = first().toInt()
    val buses = last()
        .split(",")
        .mapIndexed { index, stringValue ->
            if (stringValue != "x") {
                Bus(stringValue.toLong(), index)
            } else {
                null
            }
        }
        .filterNotNull()

    Pair(timestamp, buses)
}

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
