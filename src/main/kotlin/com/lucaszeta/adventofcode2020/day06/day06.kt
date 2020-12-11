package com.lucaszeta.adventofcode2020.day06

import com.lucaszeta.adventofcode2020.ext.getResourceAsText

fun main() {
    val input = parseData(getResourceAsText("/day06/customs-form-answers.txt"))

    val sumQuestionsAnyoneAnswered = input
        .map(::countQuestionsAnyoneAnswered)
        .reduce(Int::plus)

    val sumQuestionsEveryoneAnswered = input
        .map(::countQuestionsEveryoneAnswered)
        .reduce(Int::plus)

    println("Sum of questions anyone answered: $sumQuestionsAnyoneAnswered")
    println("Sum of questions everyone answered: $sumQuestionsEveryoneAnswered")
}

fun countQuestionsAnyoneAnswered(questions: List<String>) =
    questions.joinToString("").toSet().size

fun countQuestionsEveryoneAnswered(questions: List<String>) = questions
    .map { it.chunked(1) }
    .reduce { commonQuestions, currentQuestions ->
        commonQuestions.intersect(currentQuestions).toList()
    }.size

fun parseData(input: String) = input
    .split("\n\n")
    .map { group ->
        group.split("\n").filter { it.isNotEmpty() }
    }
