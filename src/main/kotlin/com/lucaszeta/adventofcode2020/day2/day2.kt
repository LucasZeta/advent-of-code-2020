package com.lucaszeta.adventofcode2020.day2

fun countSledRentalValidPasswords(input: List<String>) =
    input.map { PasswordValidation(it) }.count { it.isSledRentalValid() }

fun main() {
    println(countSledRentalValidPasswords(input))
}
