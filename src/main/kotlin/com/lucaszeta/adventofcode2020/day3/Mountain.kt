package com.lucaszeta.adventofcode2020.day3

class Mountain(private val map: List<String>) {

    private val mapWidth: Int
        get() = map.first().length

    private val mapHeight: Int
        get() = map.size - 1

    fun countTrees(slope: Slope): Int {
        var treeCount = 0
        val toboggan = Toboggan(mapWidth)

        while (toboggan.y < mapHeight) {
            toboggan.goToNextPosition(slope)

            if (isTree(toboggan.x, toboggan.y)) {
                treeCount++
            }
        }

        return treeCount
    }

    private fun isTree(x: Int, y: Int) = map[y][x] == TREE

    companion object {
        const val TREE = '#'
    }
}
