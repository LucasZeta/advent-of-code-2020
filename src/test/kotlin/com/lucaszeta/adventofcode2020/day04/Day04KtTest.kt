package com.lucaszeta.adventofcode2020.day04

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04KtTest {

    @Test
    fun `Should parse data`() {
        val input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
            "byr:1937 iyr:2017 cid:147 hgt:183cm\n" +
            "\n" +
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
            "hcl:#cfa07d byr:1929\n" +
            "\n" +
            "hcl:#ae17e1 iyr:2013\n" +
            "eyr:2024\n" +
            "ecl:brn pid:760753108 byr:1931\n" +
            "hgt:179cm\n" +
            "\n" +
            "hcl:#cfa07d eyr:2025 pid:166559648\n" +
            "iyr:2011 ecl:brn hgt:59in"

        val expectedOutput = listOf(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929",
            "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm",
            "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in"
        )

        assertEquals(expectedOutput, parseData(input))
    }

    @Test
    fun `Should count passports with present data`() {
        val input = listOf(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929",
            "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm",
            "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in"
        )

        assertEquals(2, countPassportsWithPresentData(input))
    }

    @Test
    fun `Should count passports with valid data`() {
        val input = listOf(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:200cm",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929",
            "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm",
            "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in"
        )

        assertEquals(1, countPassportsWithValidData(input))
    }
}
