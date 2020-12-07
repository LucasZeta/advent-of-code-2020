package com.lucaszeta.adventofcode2020.day7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day7Test {

    @Test
    fun `Should parse data`() {
        val input = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "bright white bags contain 1 shiny gold bag.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
            "faded blue bags contain no other bags.\n" +
            "dotted black bags contain no other bags.\n"

        val expectedOutput = listOf(
            Bag("light red", mapOf("bright white" to 1, "muted yellow" to 2)),
            Bag("dark orange", mapOf("bright white" to 3, "muted yellow" to 4)),
            Bag("bright white", mapOf("shiny gold" to 1)),
            Bag("muted yellow", mapOf("shiny gold" to 2, "faded blue" to 9)),
            Bag("shiny gold", mapOf("dark olive" to 1, "vibrant plum" to 2)),
            Bag("dark olive", mapOf("faded blue" to 3, "dotted black" to 4)),
            Bag("vibrant plum", mapOf("faded blue" to 5, "dotted black" to 6)),
            Bag("faded blue", mapOf()),
            Bag("dotted black", mapOf())
        )

        assertEquals(expectedOutput, parseData(input))
    }

    @Test
    fun `Should contain shiny gold bag`() {
        val input = listOf(
            Bag("light red", mapOf("bright white" to 1, "muted yellow" to 2)),
            Bag("dark orange", mapOf("bright white" to 3, "muted yellow" to 4)),
            Bag("bright white", mapOf("shiny gold" to 1)),
            Bag("muted yellow", mapOf("shiny gold" to 2, "faded blue" to 9)),
            Bag("custom color", mapOf("dark olive" to 2, "light red" to 9)),
            Bag("custom color 2", mapOf("faded blue" to 2, "custom color" to 5)),
            Bag("shiny gold", mapOf("dark olive" to 1, "vibrant plum" to 2)),
            Bag("dark olive", mapOf("faded blue" to 3, "dotted black" to 4)),
            Bag("vibrant plum", mapOf("faded blue" to 5, "dotted black" to 6)),
            Bag("faded blue", mapOf()),
            Bag("dotted black", mapOf())
        )

        assertTrue(canContain(input[0], "shiny gold", input))
        assertTrue(canContain(input[1], "shiny gold", input))
        assertTrue(canContain(input[2], "shiny gold", input))
        assertTrue(canContain(input[3], "shiny gold", input))
        assertTrue(canContain(input[4], "shiny gold", input))
        assertTrue(canContain(input[5], "shiny gold", input))
    }

    @Test
    fun `Should not contain shiny gold bag`() {
        val input = listOf(
            Bag("light red", mapOf("bright white" to 1, "muted yellow" to 2)),
            Bag("dark orange", mapOf("bright white" to 3, "muted yellow" to 4)),
            Bag("bright white", mapOf("shiny gold" to 1)),
            Bag("muted yellow", mapOf("shiny gold" to 2, "faded blue" to 9)),
            Bag("shiny gold", mapOf("dark olive" to 1, "vibrant plum" to 2)),
            Bag("dark olive", mapOf("faded blue" to 3, "dotted black" to 4)),
            Bag("vibrant plum", mapOf("faded blue" to 5, "dotted black" to 6)),
            Bag("faded blue", mapOf()),
            Bag("dotted black", mapOf())
        )

        assertFalse(canContain(input[4], "shiny gold", input))
        assertFalse(canContain(input[5], "shiny gold", input))
        assertFalse(canContain(input[6], "shiny gold", input))
        assertFalse(canContain(input[7], "shiny gold", input))
        assertFalse(canContain(input[8], "shiny gold", input))
    }

    @Test
    fun `Should count bags that contain shiny gold bag`() {
        val input = listOf(
            Bag("light red", mapOf("bright white" to 1,"muted yellow" to 2)),
            Bag("dark orange", mapOf("bright white" to 3, "muted yellow" to 4)),
            Bag("bright white", mapOf("shiny gold" to 1)),
            Bag("muted yellow", mapOf("shiny gold" to 2, "faded blue" to 9)),
            Bag("shiny gold", mapOf("dark olive" to 1, "vibrant plum" to 2)),
            Bag("dark olive", mapOf("faded blue" to 3, "dotted black" to 4)),
            Bag("vibrant plum", mapOf("faded blue" to 5, "dotted black" to 6)),
            Bag("faded blue", mapOf()),
            Bag("dotted black", mapOf())
        )

        assertEquals(4, countBagsThatCanContain(input, "shiny gold"))
    }

    @Test
    fun `Should count bags inside a shiny gold bag`() {
        val input = listOf(
            Bag("light red", listOf(1 to "bright white", 2 to "muted yellow")),
            Bag("dark orange", listOf(3 to "bright white", 4 to "muted yellow")),
            Bag("bright white", listOf(1 to "shiny gold")),
            Bag("muted yellow", listOf(2 to "shiny gold", 9 to "faded blue")),
            Bag("shiny gold", listOf(1 to "dark olive", 2 to "vibrant plum")),
            Bag("dark olive", listOf(3 to "faded blue", 4 to "dotted black")),
            Bag("vibrant plum", listOf(5 to "faded blue", 6 to "dotted black")),
            Bag("faded blue", listOf()),
            Bag("dotted black", listOf())
        )

        assertEquals(32, countIndividualBagsInside(input, "shiny gold"))
    }

    @Test
    fun `Should count bags inside a shiny gold bag deep inside multiple levels`() {
        val input = listOf(
            Bag("shiny gold", listOf(2 to "dark red")),
            Bag("dark red", listOf(2 to "dark orange")),
            Bag("dark orange", listOf(2 to "dark yellow")),
            Bag("dark yellow", listOf(2 to "dark green")),
            Bag("dark green", listOf(2 to "dark blue")),
            Bag("dark blue", listOf(2 to "dark violet")),
            Bag("dark violet", listOf())
        )

        assertEquals(126, countIndividualBagsInside(input, "shiny gold"))
    }
}
