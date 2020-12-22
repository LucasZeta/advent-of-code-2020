package com.lucaszeta.adventofcode2020.day22

fun parseDeck(input: String) = input
    .split("\n")
    .filter { "(\\d+)".toRegex().matches(it) }
    .map { it.toInt() }
