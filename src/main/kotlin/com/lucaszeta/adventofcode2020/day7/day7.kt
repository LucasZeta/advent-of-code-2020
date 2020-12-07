package com.lucaszeta.adventofcode2020.day7

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val bags = parseData(getResourceAsText("/day7/rules-list.txt"))

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
    val foundBag = bags.find { it.color == color }
    if (foundBag != null) {
        if (foundBag.canContain.isEmpty()) return if (!firstLevel) 1 else 0

        var count = if (!firstLevel) 1 else 0

        foundBag.canContain.forEach { (quantity, color) ->
            count += quantity * countIndividualBagsInside(bags, color, false)
        }

        return count
    } else {
        return 0
    }
}

fun canContain(bag: Bag, targetColor: String, bags: List<Bag>): Boolean {
    if (bag.canContain.isEmpty()) return false

    val containsBagWithTargetColor = bag.canContain.find { it.second == targetColor }

    if (containsBagWithTargetColor != null) {
        return true
    } else {
        for ((_, color) in bag.canContain) {
            val foundBag = bags.find { it.color == color }
            if (foundBag != null) {
                if (canContain(foundBag, targetColor, bags)) {
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
            val allowedInnerBags = mutableListOf<Pair<Int, String>>()
            val (color, allowedInnerBagsText) = line.split(colorInnerBagsDelimiter)

            val result = "(\\d+) ([a-z ]*) bag(s)?([,.])"
                .toRegex()
                .findAll(allowedInnerBagsText)

            result.forEach {
                allowedInnerBags.add(it.groupValues[1].toInt() to it.groupValues[2])
            }

            Bag(color, allowedInnerBags.toList())
        }
}
