package com.lucaszeta.adventofcode2020.day25

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

const val SUBJECT_NUMBER = 7

fun main() {
    val (cardPublicKey, doorPublicKey) = getResourceAsText("/day25/public-keys.txt")
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

    val cardLoopSize = findLoopSize(cardPublicKey, SUBJECT_NUMBER)
    val doorLoopSize = findLoopSize(doorPublicKey, SUBJECT_NUMBER)

    val encryptionKey1 = generateEncryptionKey(cardPublicKey, doorLoopSize)
    val encryptionKey2 = generateEncryptionKey(doorPublicKey, cardLoopSize)

    println("Loop sizes: $cardLoopSize and $doorLoopSize")
    println("Encryption keys: $encryptionKey1 and $encryptionKey2")
}

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
