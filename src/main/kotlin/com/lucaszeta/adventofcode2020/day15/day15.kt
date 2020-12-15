package com.lucaszeta.adventofcode2020.day15

fun findNthNumber(numbers: List<Int>, listSize: Int): Int {
    val mutableList = numbers.toMutableList()

    while (mutableList.size < listSize) {
        val nextNumber = nextNumber(mutableList)
        mutableList.add(nextNumber)
    }

    return mutableList.last()
}

fun nextNumber(numbers: List<Int>): Int {
    val mostRecentNumber = numbers.last()

    return if (numbers.count { it == mostRecentNumber } == 1) {
        0
    } else {
        val lastIndex = numbers.lastIndexOf(mostRecentNumber)
        val indexBefore = numbers
            .toMutableList()
            .apply { removeAt(lastIndex) }
            .lastIndexOf(mostRecentNumber)

        (lastIndex + 1) - (indexBefore + 1)
    }
}
