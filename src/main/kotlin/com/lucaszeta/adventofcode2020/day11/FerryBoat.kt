package com.lucaszeta.adventofcode2020.day11

class FerryBoat(
    input: List<String>
) {

    var seatLayout: List<List<Char>>
        private set

    init {
        val mutableSeatList = mutableListOf<List<Char>>()

        input.forEach { line ->
            mutableSeatList.add(line.toCharArray().toList())
        }

        seatLayout = mutableSeatList.toList()
    }

    companion object {
        const val EMPTY_SEAT = 'L'
        const val OCCUPIED_SEAT = '#'
        const val FLOOR = '.'
    }
}
