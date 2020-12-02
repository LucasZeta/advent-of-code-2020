package com.lucaszeta.adventofcode2020.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class PasswordValidationTest {

    @Test
    fun `Should map input correctly`() {
        val validation = PasswordValidation("1-3 a: abcde")

        assertEquals(1, validation.minLength)
        assertEquals(3, validation.maxLength)
        assertEquals("a", validation.char)
        assertEquals("abcde", validation.password)
    }

    @Test
    fun `Should throw exception when input is invalid`() {
        assertThrows<IllegalArgumentException> {
            PasswordValidation("1xxx3 a- abcde")
        }
    }
}
