package com.lucaszeta.adventofcode2020.day20

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val tiles = getResourceAsText("/day20/tiles.txt")
        .split("\n\n")
        .map(::ImageTile)

    val cornerTiles = findCornerTiles(tiles)
    val cornerTilesProduct = cornerTiles
        .map { it.first }
        .reduce(Long::times)

    println("Product of corner tiles ID $cornerTilesProduct")
}

fun findCornerTiles(allTiles: List<ImageTile>) = allTiles.run {
    val cornerCount = 2
    val cornersList = map { it.id to it.findCorners() }

    val matchingCorners = cornersList.map { (id, corners) ->
        val matchingCornersCount = cornersList
            .filter { it.first != id }
            .count { (_, otherCorners) ->
                corners.intersect(otherCorners).isNotEmpty()
            }

        id to matchingCornersCount
    }

    return@run matchingCorners.filter { it.second == cornerCount }
}
