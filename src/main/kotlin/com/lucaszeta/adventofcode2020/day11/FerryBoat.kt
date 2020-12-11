package com.lucaszeta.adventofcode2020.day11

class FerryBoat(
    input: List<String>
) {

    private var shouldOccupyEmptySeat: (Int, Int) -> Boolean = { _, _ -> false }
    private var shouldAbandonOccupiedSeat: (Int, Int) -> Boolean = { _, _ -> false }

    var seatLayout: List<List<Char>>
        private set

    init {
        val mutableSeatList = mutableListOf<List<Char>>()

        input.forEach { line ->
            mutableSeatList.add(line.toCharArray().toList())
        }

        seatLayout = mutableSeatList.toList()
        setOldOccupationRules()
    }

    private fun setOldOccupationRules() {
        shouldOccupyEmptySeat = { y, x ->
            findAdjacentSeats(y, x).count { it == OCCUPIED_SEAT } == 0
        }

        shouldAbandonOccupiedSeat = { y, x ->
            findAdjacentSeats(y, x).count { it == OCCUPIED_SEAT } >= 4
        }
    }

    fun simulateSeatOccupation() {
        val newSeatLayout = mutableListOf<MutableList<Char>>()

        for (y in seatLayout.indices) {
            newSeatLayout.add(mutableListOf())

            for (x in seatLayout[y].indices) {
                val seat = seatLayout[y][x]

                val newSeat = if (seat == EMPTY_SEAT && shouldOccupyEmptySeat(y, x)) {
                    OCCUPIED_SEAT
                } else if (seat == OCCUPIED_SEAT && shouldAbandonOccupiedSeat(y, x)) {
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
