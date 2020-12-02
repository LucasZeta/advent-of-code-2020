package com.lucaszeta.adventofcode2020.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class PasswordValidationTest {

    @Test
    fun `Should map input correctly`() {
        val validation = PasswordValidation("1-3 a: abcde")

        assertEquals(1, validation.minLength)
        assertEquals(3, validation.maxLength)
        assertEquals("a".single(), validation.char)
        assertEquals("abcde", validation.password)
    }

    @Test
    fun `Should throw exception when input is invalid`() {
        assertThrows<IllegalArgumentException> {
            PasswordValidation("1xxx3 a- abcde")
        }
    }

    @Test
    fun `Should validate password for Sled Rental policy`() {
        val validation = PasswordValidation("1-3 a: abcde")

        assertTrue(validation.isSledRentalValid())
    }

    @Test
    fun `Should not validate password with too little char count for Sled Rental policy`() {
        val validation = PasswordValidation("2-3 a: abcde")

        assertFalse(validation.isSledRentalValid())
    }

    @Test
    fun `Should not validate password with too much char count for Sled Rental policy`() {
        val validation = PasswordValidation("2-3 a: aaaabcde")

        assertFalse(validation.isSledRentalValid())
    }

    @Test
    fun `Should not validate password with no existing char for Sled Rental policy`() {
        val validation = PasswordValidation("1-3 a: bcde")

        assertFalse(validation.isSledRentalValid())
    }
}
