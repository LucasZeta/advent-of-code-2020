package com.lucaszeta.adventofcode2020.day20

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
