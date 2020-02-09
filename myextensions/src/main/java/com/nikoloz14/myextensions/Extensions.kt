package com.nikoloz14.myextensions

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

fun Context?.showToast(message: String) {
    Toast.makeText(this, message, LENGTH_LONG).show()
}

fun String.showToast(context: Context?) {
    context.showToast(this)
}