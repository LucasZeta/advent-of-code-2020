package com.lucaszeta.adventofcode2020.day07

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val bags = parseData(getResourceAsText("/day07/rules-list.txt"))

    val bagsThatContainShinyGold = countBagsThatCanContain(bags, "shiny gold")
    val bagsInsideShinyGold = countIndividualBagsInside(bags, "shiny gold")

    println("Bags that can contain shiny gold bag: %d".format(bagsThatContainShinyGold))
    println("Bags inside shiny gold bag: %d".format(bagsInsideShinyGold))
}

fun countBagsThatCanContain(bags: List<Bag>, color: String): Int {
    var bagsThatCanContainColor = 0

    bags.forEach { bag ->
        if (canContain(bag, color, bags)) {
            bagsThatCanContainColor++
        }
    }

    return bagsThatCanContainColor
}

fun countIndividualBagsInside(
    bags: List<Bag>,
    color: String,
    firstLevel: Boolean = true
): Int {
    bags.find { it.color == color }?.let { bag ->
        if (bag.contents.isEmpty()) return if (firstLevel) 0 else 1

        var count = if (firstLevel) 0 else 1

        bag.contents.forEach { (color, quantity) ->
            count += quantity * countIndividualBagsInside(bags, color, false)
        }

        return count
    } ?: return 0
}

fun canContain(bag: Bag, targetColor: String, bags: List<Bag>): Boolean {
    if (bag.contents.isEmpty()) return false

    if (bag.contents.containsKey(targetColor)) {
        return true
    } else {
        for (color in bag.contents.keys) {
            bags.find { it.color == color }?.let {
                if (canContain(it, targetColor, bags)) {
                    return true
                }
            }
        }

        return false
    }
}

fun parseData(input: String): List<Bag> {
    val colorInnerBagsDelimiter = " bags contain "

    return input.split("\n")
        .filter { it.isNotEmpty() }
        .map { line ->
            val allowedInnerBags = mutableMapOf<String, Int>()
            val (color, allowedInnerBagsText) = line.split(colorInnerBagsDelimiter)

            val result = "(\\d+) ([a-z ]*) bag(s)?([,.])"
                .toRegex()
                .findAll(allowedInnerBagsText)

            result.forEach {
                allowedInnerBags[it.groupValues[2]] = it.groupValues[1].toInt()
            }

            Bag(color, allowedInnerBags.toMap())
        }
}
