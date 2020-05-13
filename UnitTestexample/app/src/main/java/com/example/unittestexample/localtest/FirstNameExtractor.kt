package com.example.unittestexample.localtest

object FirstNameExtractor {
    fun extractFirstName(fullName: String?): String? {
        if (fullName == null || fullName.isEmpty()) {
            return ""
        }
        val split = fullName.split(" ").toTypedArray()
        for (word in split) {
            if (!word.isEmpty()) {
                return word
            }
        }
        return null
    }
}