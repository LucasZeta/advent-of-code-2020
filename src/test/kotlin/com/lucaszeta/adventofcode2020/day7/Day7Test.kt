package com.lucaszeta.adventofcode2020.day7

import org.junit.jupiter.api.Assertions.assertEquals
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

        assertEquals(expectedOutput, parseData(input))
    }
}
