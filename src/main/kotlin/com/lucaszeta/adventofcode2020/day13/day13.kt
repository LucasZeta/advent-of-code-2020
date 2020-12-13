package com.lucaszeta.adventofcode2020.day13

import java.lang.IllegalArgumentException

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
