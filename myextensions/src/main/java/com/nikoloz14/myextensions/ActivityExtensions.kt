package com.nikoloz14.myextensions

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.inputmethod.InputMethodManager
import com.nikoloz14.myextensions.model.ScreenDimension

fun Activity.hideKeyboard() {
    try {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    } catch (e: Exception) {
        // TODO: handle exception
    }
}

fun Activity.getScreenDimensions(): ScreenDimension {
    val displayMetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displayMetrics)
    return ScreenDimension(
        displayMetrics.widthPixels,
        displayMetrics.heightPixels
    )
}

val Activity.screenWidth: Int
    get() = this.getScreenDimensions().width

val Activity.screenHeight: Int
    get() = this.getScreenDimensions().height