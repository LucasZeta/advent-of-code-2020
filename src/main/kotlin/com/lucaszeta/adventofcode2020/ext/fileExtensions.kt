package com.lucaszeta.adventofcode2020.ext

fun getResourceAsText(path: String): String {
    return object {}.javaClass.getResource(path).readText()
}
