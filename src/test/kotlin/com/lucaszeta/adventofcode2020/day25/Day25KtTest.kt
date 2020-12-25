package com.lucaszeta.adventofcode2020.day25

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day25KtTest {

    @Test
    fun `Should generate encryption key`() {
        val expectedEncryptionKey = 14897079L

        val encryptionKey1 = generateEncryptionKey(5764801, 11)
        val encryptionKey2 = generateEncryptionKey(17807724, 8)

        assertEquals(expectedEncryptionKey, encryptionKey1)
        assertEquals(expectedEncryptionKey, encryptionKey2)
    }

    @Test
    fun `Should discover loop size`() {
        assertEquals(8, findLoopSize(5764801, 7))
        assertEquals(11, findLoopSize(17807724, 7))
    }
}
