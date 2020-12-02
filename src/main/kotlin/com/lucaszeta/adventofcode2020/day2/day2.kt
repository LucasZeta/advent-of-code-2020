package com.lucaszeta.adventofcode2020.day2

fun countValidPasswords(input: List<String>) =
    input.map { PasswordValidation(it) }.count { it.isValid() }

fun main() {
    println(countValidPasswords(input))
}
