package com.lucaszeta.adventofcode2020.day6

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val input = parseData(getResourceAsText("/day6/customs-form-answers.txt"))

    val sumQuestionsAnyoneAnswered = input
        .map(::countQuestionsAnyoneAnswered)
        .reduce { acc, questionCount -> acc + questionCount }

    println("Sum of questions anyone answered: $sumQuestionsAnyoneAnswered")
}

fun countQuestionsAnyoneAnswered(questions: String) =
    questions.toSet().size

fun parseData(input: String) = input
    .replace("([a-z])\\n".toRegex()) {
        it.groupValues[1]
    }
    .split("\n")
    .filter { it.isNotEmpty() }
