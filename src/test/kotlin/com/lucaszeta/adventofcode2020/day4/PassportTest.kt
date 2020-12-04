package com.lucaszeta.adventofcode2020.day4

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PassportTest {

    @Test
    fun `Should validate passport with all eight fields`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"

        assertTrue(Passport(input).isValid())
    }

    @Test
    fun `Should validate passport missing only the country ID`() {
        val input = "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"

        assertTrue(Passport(input).isValid())
    }

    @Test
    fun `Should not validate passport missing a field that is not the country ID`() {
        val input = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929"

        assertFalse(Passport(input).isValid())
    }
}
