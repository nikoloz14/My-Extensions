package com.nikoloz14.myextensions

import android.os.Build
import android.text.Html
import android.text.InputFilter
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun TextView.setTextOrMakeGone(text: String?) =
    text?.let { setText(it) } ?: makeGone()

fun TextView.setTextOrMakeInvisible(text: String?) =
    text?.let { setText(it) } ?: makeInvisible()

fun TextView.setHtmlText(text: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
    } else {
        setText(Html.fromHtml(text))
    }
}

fun TextView.setTextColorResource(@ColorRes colorRes: Int) {
    this.setTextColor(ContextCompat.getColor(this.context, colorRes))
}

fun TextView.setMaxLength(maxLength: Int) {
    val fArray = arrayOfNulls<InputFilter>(1)
    fArray[0] = InputFilter.LengthFilter(maxLength)
    this.filters = fArray
}