package com.lucaszeta.adventofcode2020.day2

fun countSledRentalValidPasswords(input: List<String>) =
    input.map(::PasswordValidation).count { it.isSledRentalValid() }

fun countTobogganValidPasswords(input: List<String>) =
    input.map(::PasswordValidation).count { it.isTobogganValid() }

fun main() {
    println("Sled Rental valid passwords: %d".format(countSledRentalValidPasswords(input)))
    println("Toboggan Corporate valid passwords: %d".format(countTobogganValidPasswords(input)))
}
