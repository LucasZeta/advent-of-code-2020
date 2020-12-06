package com.lucaszeta.adventofcode2020.day6

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val input = parseData(getResourceAsText("/day6/customs-form-answers.txt"))

    val sumQuestionsAnyoneAnswered = input
        .map(::countQuestionsAnyoneAnswered)
        .reduce { acc, questionCount -> acc + questionCount }

    println("Sum of questions anyone answered: $sumQuestionsAnyoneAnswered")
}

fun countQuestionsAnyoneAnswered(questions: List<String>) =
    questions.joinToString("").toSet().size

fun parseData(input: String) = input
    .split("\n\n")
    .filter { it.isNotEmpty() }
    .map {
        it.split("\n")
    }
