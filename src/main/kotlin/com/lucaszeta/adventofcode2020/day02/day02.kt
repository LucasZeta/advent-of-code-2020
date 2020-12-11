package com.lucaszeta.adventofcode2020.day02

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun countSledRentalValidPasswords(input: List<String>) =
    input.map(::PasswordValidation).count { it.isSledRentalValid() }

fun countTobogganValidPasswords(input: List<String>) =
    input.map(::PasswordValidation).count { it.isTobogganValid() }

fun main() {
    val input = getResourceAsText("/day02/password-list.txt")
        .split("\n")
        .filter { it.isNotEmpty() }

    println("Sled Rental valid passwords: %d".format(countSledRentalValidPasswords(input)))
    println("Toboggan Corporate valid passwords: %d".format(countTobogganValidPasswords(input)))
}
