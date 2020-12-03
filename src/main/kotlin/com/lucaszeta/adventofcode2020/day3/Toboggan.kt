package com.lucaszeta.adventofcode2020.day3

class Toboggan(
    private val mapWidth: Int
) {
    var x: Int = 0
        private set
    var y: Int = 0
        private set

    fun goToNextPosition(slope: Slope) {
        x += slope.right
        if (x > mapWidth - 1) {
            x -= mapWidth
        }

        y += slope.down
    }
}
