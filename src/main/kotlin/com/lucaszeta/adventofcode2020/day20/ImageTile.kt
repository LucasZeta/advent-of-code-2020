package com.lucaszeta.adventofcode2020.day20

class ImageTile(input: String) {

    val id: Long
    val grid = mutableListOf<List<Char>>()

    init {
        val lines = input.split("\n")
            .filter { it.isNotEmpty() }

        id = lines.first()
            .removePrefix("Tile ")
            .removeSuffix(":")
            .toLong()
        lines.drop(1).forEach {
            grid.add(it.toList())
        }
    }
}
