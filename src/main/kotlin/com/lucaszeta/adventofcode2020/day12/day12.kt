package com.lucaszeta.adventofcode2020.day12

import kotlin.math.abs

fun calculateManhattanDistance(
    currentX: Int,
    currentY: Int,
    originX: Int,
    originY: Int
) = abs(currentX - originX) + abs(currentY - originY)
