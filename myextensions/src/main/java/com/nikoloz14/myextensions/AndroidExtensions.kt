package com.nikoloz14.myextensions

import android.content.Context
import android.content.res.Resources
import android.os.Handler
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Context?.showToast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context?.showToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun String?.showToast(context: Context?) {
    context.showToast(this)
}

fun Int.showToast(context: Context?) {
    context.showToast(this)
}

fun Context.getCompatColor(@ColorRes color: Int) =
    ContextCompat.getColor(this, color)

val Int.asDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.asPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Float.asDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Float.asPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun postDelayed(time: Long, runnable: Runnable) {
    Handler().postDelayed(runnable, time)
}

fun postDelayed(time: Long, block: () -> Unit) {
    Handler().postDelayed(Runnable(block), time)
}
