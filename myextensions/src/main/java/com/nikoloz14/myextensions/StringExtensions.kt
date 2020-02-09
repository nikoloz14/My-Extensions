package com.nikoloz14.myextensions

fun String.splitName() : Pair<String, String> {
    var parts  = split(" ").toMutableList()
    val firstName = parts.firstOrNull() ?: this
    parts.removeAt(0)
    var lastName = parts.joinToString(" ")
    return firstName to lastName
}

fun String.forceCapitalise(): String {
    return if (isNotEmpty()) substring(0, 1).toUpperCase() + substring(1).toLowerCase() else this
}

fun String.isNumeric(): Boolean {
    return this.matches("-?\\d+(\\.\\d+)?".toRegex())
}

fun String?.isNotNullNorEmpty() = !this.isNullOrEmpty()

inline fun <T> T?.wrap() = "$this"

inline fun String.splitLines() = split('\n')

inline fun String.remove(substring: String) = replace(substring, "")