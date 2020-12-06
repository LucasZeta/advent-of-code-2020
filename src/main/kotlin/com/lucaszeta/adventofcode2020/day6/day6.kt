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

fun countQuestionsEveryoneAnswered(questions: List<String>): Int {
    val allQuestions = questions.joinToString("").toCharArray()
    val uniqueQuestions = questions.joinToString("").toSet()

    return uniqueQuestions.map { question ->
        allQuestions.count { it == question }
    }.filter { count ->
        count == questions.size
    }.size
}

fun parseData(input: String) = input
    .split("\n\n")
    .map { group ->
        group.split("\n").filter { it.isNotEmpty() }
    }
