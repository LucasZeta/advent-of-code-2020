package com.lucaszeta.adventofcode2020.day25

fun generateEncryptionKey(
    subjectNumber: Int,
    loopSize: Int
): Long {
    var accumulator = 1L

    repeat(loopSize) {
        accumulator = (accumulator * subjectNumber).rem(20201227)
    }

    return accumulator
}

fun findLoopSize(publicKey: Int, subjectNumber: Int): Int {
    var loopSize = 0
    var accumulator = 1

    do {
        accumulator = (accumulator * subjectNumber).rem(20201227)
        loopSize++
    } while (accumulator != publicKey)

    return loopSize
}
