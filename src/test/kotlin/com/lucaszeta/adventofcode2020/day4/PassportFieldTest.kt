package com.lucaszeta.adventofcode2020.day4

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PassportFieldTest {

    @Nested
    inner class BirthYearTest {

        @Test
        fun `Should validate birth year between and 1920 and 2002`() {
            assertTrue(PassportField.BIRTH_YEAR.isValid("1920"))
            assertTrue(PassportField.BIRTH_YEAR.isValid("1961"))
            assertTrue(PassportField.BIRTH_YEAR.isValid("2002"))
        }

        @Test
        fun `Should not validate birth year before 1920`() {
            assertFalse(PassportField.BIRTH_YEAR.isValid("1919"))
        }

        @Test
        fun `Should not validate birth year after 2002`() {
            assertFalse(PassportField.BIRTH_YEAR.isValid("2003"))
        }
    }

    @Nested
    inner class IssueYearTest {

        @Test
        fun `Should validate issue year between and 2010 and 2020`() {
            assertTrue(PassportField.ISSUE_YEAR.isValid("2010"))
            assertTrue(PassportField.ISSUE_YEAR.isValid("2015"))
            assertTrue(PassportField.ISSUE_YEAR.isValid("2020"))
        }

        @Test
        fun `Should not validate issue year before 2010`() {
            assertFalse(PassportField.ISSUE_YEAR.isValid("2009"))
        }

        @Test
        fun `Should not validate issue year after 2020`() {
            assertFalse(PassportField.ISSUE_YEAR .isValid("2021"))
        }
    }

    @Nested
    inner class ExpirationYearTest {

        @Test
        fun `Should validate expiration year between and 2020 and 2030`() {
            assertTrue(PassportField.EXPIRATION_YEAR.isValid("2020"))
            assertTrue(PassportField.EXPIRATION_YEAR.isValid("2025"))
            assertTrue(PassportField.EXPIRATION_YEAR.isValid("2030"))
        }

        @Test
        fun `Should not validate expiration year before 2020`() {
            assertFalse(PassportField.EXPIRATION_YEAR.isValid("2019"))
        }

        @Test
        fun `Should not validate expiration year after 2030`() {
            assertFalse(PassportField.EXPIRATION_YEAR.isValid("2031"))
        }
    }

    @Nested
    inner class HairColorTest {

        @Test
        fun `Should validate hair color that are valid hexadecimal values`() {
            assertTrue(PassportField.HAIR_COLOR.isValid("#abcdef"))
            assertTrue(PassportField.HAIR_COLOR.isValid("#1a2b3c"))
            assertTrue(PassportField.HAIR_COLOR.isValid("#123456"))
        }

        @Test
        fun `Should not validate hair color that doesn't have # preceding it`() {
            assertFalse(PassportField.HAIR_COLOR.isValid("abcdef"))
        }

        @Test
        fun `Should not validate hair color that doesn't have 6 digits`() {
            assertFalse(PassportField.HAIR_COLOR.isValid("#12345"))
        }

        @Test
        fun `Should not validate hair color that are invalid hexadecimal values`() {
            assertFalse(PassportField.HAIR_COLOR.isValid("#bcdefg"))
            assertFalse(PassportField.HAIR_COLOR.isValid("1a2b3j"))
        }
    }

    @Nested
    inner class EyeColorTest {

        @Test
        fun `Should validate eye color that are in the valid group`() {
            assertTrue(PassportField.EYE_COLOR.isValid("amb"))
            assertTrue(PassportField.EYE_COLOR.isValid("blu"))
            assertTrue(PassportField.EYE_COLOR.isValid("brn"))
            assertTrue(PassportField.EYE_COLOR.isValid("gry"))
            assertTrue(PassportField.EYE_COLOR.isValid("grn"))
            assertTrue(PassportField.EYE_COLOR.isValid("hzl"))
            assertTrue(PassportField.EYE_COLOR.isValid("oth"))
        }

        @Test
        fun `Should not validate eye color that are not in the valid group`() {
            assertFalse(PassportField.EYE_COLOR.isValid("abc"))
            assertFalse(PassportField.EYE_COLOR.isValid("def"))
        }
    }
}
