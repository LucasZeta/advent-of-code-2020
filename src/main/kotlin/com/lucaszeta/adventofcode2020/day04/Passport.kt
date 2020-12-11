package com.lucaszeta.adventofcode2020.day04

class Passport(input: String) {

    private val fields: Map<String, String>

    init {
        val map = mutableMapOf<String, String>()

        input.split(" ").map {
            val keyValue = it.split(":")

            if (acceptableFields.contains(keyValue.first())) {
                map[keyValue.first()] = keyValue.last()
            }
        }

        fields = map
    }

    fun areAllFieldsPresent(): Boolean {
        val hasAllFields = fields.size == REQUIRED_NUMBER_OF_FIELDS
        val isMissingOnlyOptionalField = fields.size == REQUIRED_NUMBER_OF_FIELDS - 1 &&
            !fields.containsKey(OPTIONAL_FIELD_KEY)

        return hasAllFields || isMissingOnlyOptionalField
    }

    fun areAllFieldsValid(): Boolean {
        if (!areAllFieldsPresent()) return false

        fields.forEach { (key, value) ->
            if (!PassportField.fromKey(key).isValid(value)) {
                return false
            }
        }

        return true
    }

    companion object {
        val acceptableFields = PassportField.values().map { it.key }.toList()
        val OPTIONAL_FIELD_KEY = PassportField.COUNTRY_ID.key

        const val REQUIRED_NUMBER_OF_FIELDS = 8
    }
}
