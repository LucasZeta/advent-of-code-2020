package com.lucaszeta.adventofcode2020.day4

class Passport(input: String) {

    private val fields: Map<String, String>

    init {
        val map = mutableMapOf<String, String>()

        input.split(" ").map {
            val keyValue = it.split(":")

            if (acceptableFields.contains(keyValue[0])) {
                map[keyValue[0]] = keyValue[1]
            }
        }

        fields = map
    }

    fun areAllFieldsPresent(): Boolean {
        val hasAllFields = fields.size == REQUIRED_NUMBER_OF_FIELDS
        val isMissingOnlyOptionalField = fields.size == REQUIRED_NUMBER_OF_FIELDS -1 &&
                !fields.containsKey(OPTIONAL_FIELD_KEY)

        return hasAllFields || isMissingOnlyOptionalField
    }

    fun areAllFieldsValid() = false

    companion object {
        val acceptableFields = listOf(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid",
            "cid"
        )

        const val OPTIONAL_FIELD_KEY = "cid"
        const val REQUIRED_NUMBER_OF_FIELDS = 8
    }
}
