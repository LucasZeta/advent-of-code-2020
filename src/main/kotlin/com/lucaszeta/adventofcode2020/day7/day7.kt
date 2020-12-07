package com.lucaszeta.adventofcode2020.day7

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
    val emptyInnerBagText = "no other bags."

    return input.split("\n")
        .filter { it.isNotEmpty() }
        .map { line ->
            val allowedInnerBags = mutableListOf<Pair<Int, String>>()
            val (color, allowedInnerBagsText) = line.split(colorInnerBagsDelimiter)

            if (allowedInnerBagsText != emptyInnerBagText) {
                val result = "(\\d+) ([a-z ]*) bag(s)?([,.])"
                    .toRegex()
                    .findAll(allowedInnerBagsText)

                result.forEach {
                    allowedInnerBags.add(it.groupValues[1].toInt() to it.groupValues[2].trim())
                }
            }

            Bag(color, allowedInnerBags.toList())
        }
}
