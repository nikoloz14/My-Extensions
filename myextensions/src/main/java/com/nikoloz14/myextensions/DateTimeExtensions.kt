package com.nikoloz14.myextensions

import java.text.SimpleDateFormat
import java.util.*

fun Long.parseToDateFormat(dateFormatString: String): String {
    val dateFormat = SimpleDateFormat(dateFormatString)
    val date = Date(this)
    return dateFormat.format(date)
}

fun Long.parseToDateFormat(dateFormatString: String, locale: Locale): String {
    val dateFormat = SimpleDateFormat(dateFormatString, locale)
    val date = Date(this)
    return dateFormat.format(date)
}

fun Long.getDayFromDate(): Int {
    val cal = Calendar.getInstance()
    cal.timeInMillis = this
    return cal.get(Calendar.DAY_OF_MONTH)
}

fun Long.getMonthFromDate(): Int {
    val cal = Calendar.getInstance()
    cal.timeInMillis = this
    return cal.get(Calendar.MONTH) + 1
}

fun Long.getYearFromDate(): Int {
    val cal = Calendar.getInstance()
    cal.timeInMillis = this
    return cal.get(Calendar.YEAR)
}

fun Long.toEpochTime(): Long = this * 1000