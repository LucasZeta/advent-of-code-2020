package com.lucaszeta.adventofcode2020.day7

data class Bag(
    val color: String,
    val canContain: List<Pair<Int, String>> = listOf()
)
