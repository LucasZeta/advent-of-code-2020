package com.lucaszeta.adventofcode2020.ext

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FileExtensionsKtTest {

    @Test
    fun `Should read text from resources`() {
        val expectedContent = "this is just a sample text"

        assertEquals(expectedContent, getResourceAsText("/sample-input.txt"))
    }
}
