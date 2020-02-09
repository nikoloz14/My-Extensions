package com.nikoloz14.myextensions

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String?) {
    context.showToast(message)
}

fun Fragment.showToast(@StringRes message: Int) {
    context.showToast(message)
}

inline fun <T : Fragment> T.applyBundle(block: Bundle.() -> Unit): T {
    val bundle = Bundle()
    block(bundle)
    this.arguments = bundle
    return this
}

fun Fragment.hideKeyboard() {
    try {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(activity!!.currentFocus!!.windowToken, 0)
    } catch (e: Exception) {
        // TODO: handle exception
    }

}

fun Fragment.finishActivity() {
    if (activity?.isFinishing == false)
        activity?.finish()
}

fun Fragment.getScreenDimensions() = activity?.getScreenDimensions()

val Fragment.screenWidth: Int
    get() = this.getScreenDimensions()?.width ?: -1

val Fragment.screenHeight: Int
    get() = this.getScreenDimensions()?.height ?: -1