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

    fun simulateSeatOccupation() {
        val newSeatLayout = mutableListOf<MutableList<Char>>()

        for (y in seatLayout.indices) {
            newSeatLayout.add(mutableListOf())

            for (x in seatLayout[y].indices) {
                val seat = seatLayout[y][x]

                val newSeat = if (seat == EMPTY_SEAT && findAdjacentSeats(y, x).count { it == OCCUPIED_SEAT } == 0) {
                    OCCUPIED_SEAT
                } else if (seat == OCCUPIED_SEAT && findAdjacentSeats(y, x).count { it == OCCUPIED_SEAT } >= 4) {
                    EMPTY_SEAT
                } else {
                    seat
                }

                newSeatLayout.last().add(newSeat)
            }
        }

        seatLayout = newSeatLayout.toList()
    }

    private fun findAdjacentSeats(y: Int, x: Int): List<Char> {
        val adjacentSeats = mutableListOf<Char>()

        for (adjacentY in (y - 1)..(y + 1)) {
            for (adjacentX in (x - 1)..(x + 1)) {
                if (adjacentY < 0 || adjacentX < 0) continue
                if (adjacentY >= seatLayout.size || adjacentX >= seatLayout.first().size) continue
                if (adjacentY == y && adjacentX == x) continue

                adjacentSeats.add(seatLayout[adjacentY][adjacentX])
            }
        }

        return adjacentSeats.toList()
    }

    fun countOccupiedSeats() =
        seatLayout.flatten().count { it == OCCUPIED_SEAT }

    companion object {
        const val EMPTY_SEAT = 'L'
        const val OCCUPIED_SEAT = '#'
        const val FLOOR = '.'
    }
}
