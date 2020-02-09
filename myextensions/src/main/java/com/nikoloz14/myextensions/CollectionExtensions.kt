package com.nikoloz14.myextensions

import java.util.*
import kotlin.collections.ArrayList

fun <T> List<T>.toArrayList() = ArrayList(this)

inline fun <T> Collection<T?>.containsNull(): Boolean = any { it == null }
inline fun <T> Collection<T?>.everyElementIsNull(): Boolean = all { it == null }

inline fun <T : Any> Iterable<T?>.omitNullsAsList(): List<T> = filterNotNull()
inline fun <T : Any> Iterable<T?>.omitNullsAsMutableList(): MutableList<T> = filterNotNullTo(mutableListOf())

fun <T> MutableList<T>.swap(i: Int, j: Int): MutableList<T> {
    return apply {
        val aux = this[i]
        this[i] = this[j]
        this[j] = aux
    }
}

inline fun <T> List<T>.getRandomItem(generator: Random = Random()): T = get(generator.nextInt(size))

inline fun <T> MutableList<T>.shuffle(generator: Random = Random()): MutableList<T> = apply { Collections.shuffle(this, generator) }