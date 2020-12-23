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

    fun findCorners(): List<List<Char>> {
        val upperCorner = grid.first()
        val lowerCorner = grid.last()
        val leftCorner = grid.map { it.first() }
        val rightCorner = grid.map { it.last() }

        return listOf(
            upperCorner,
            upperCorner.reversed(),
            rightCorner,
            rightCorner.reversed(),
            lowerCorner,
            lowerCorner.reversed(),
            leftCorner,
            leftCorner.reversed()
        )
    }
}
