package com.nikoloz14.myextensions

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.annotation.LayoutRes

fun View.makeVisible() {
    this.visibility = VISIBLE
}

fun View.makeInvisible() {
    this.visibility = INVISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeVisibleOrGone(visible: Boolean) {
    this.visibility = if (visible) VISIBLE else View.GONE
}

fun View.makeVisibleOrInvisible(visible: Boolean) {
    this.visibility = if (visible) VISIBLE else INVISIBLE
}

fun View.isVisible() = this.visibility == VISIBLE

fun View.isInvisible() = this.visibility == INVISIBLE

fun View.isGone() = this.visibility == GONE

fun View.setPaddingStart(padding: Int) {
    setPadding(padding, paddingTop, paddingEnd, paddingBottom)
}

fun View.setPaddingLeft(padding: Int) {
    setPaddingStart(padding)
}

fun View.setPaddingTop(padding: Int) {
    setPadding(paddingStart, padding, paddingEnd, paddingBottom)
}

fun View.setPaddingEnd(padding: Int) {
    setPadding(paddingStart, paddingTop, padding, paddingBottom)
}

fun View.setPaddingRight(padding: Int) {
    setPaddingEnd(padding)
}

fun View.setPaddingBottom(padding: Int) {
    setPadding(paddingStart, paddingTop, paddingEnd, padding)
}

fun inflateView(container: ViewGroup, @LayoutRes layoutRes: Int, attachToRoot: Boolean = false) =
    LayoutInflater.from(container.context).inflate(layoutRes, container, attachToRoot)

fun View.isViewsOverlapingView(secondView: View): Boolean {
    val firstPosition = IntArray(2)
    val secondPosition = IntArray(2)

    getLocationOnScreen(firstPosition)
    secondView.getLocationOnScreen(secondPosition)
    val rectFirstView = Rect(firstPosition[0], firstPosition[1],
        firstPosition[0] + measuredWidth, firstPosition[1] + measuredHeight)
    val rectSecondView = Rect(secondPosition[0], secondPosition[1],
        secondPosition[0] + secondView.measuredWidth, secondPosition[1] + secondView.measuredHeight)
    return rectFirstView.intersect(rectSecondView);
}

fun View.getXLocationOnScreen(): Int {
    val positionArray = IntArray(2)
    getLocationOnScreen(positionArray)
    return positionArray[0]
}

fun View.getYLocationOnScreen(): Int {
    val positionArray = IntArray(2)
    getLocationOnScreen(positionArray)
    return positionArray[1]
}

fun View.changeHeightOfViewWithTreeObserver(ratio: Float) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            val width = measuredWidth
            val newHeight = ratio * measuredWidth
            val params = layoutParams
            params.height = newHeight.toInt()
            layoutParams = params
            requestLayout()
        }
    })
}
