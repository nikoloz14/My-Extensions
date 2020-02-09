package com.nikoloz14.myextensions

import android.graphics.BitmapFactory
import android.widget.ImageView

fun ImageView.setImageBytes(byteArray: ByteArray) {
    setImageBitmap(
        BitmapFactory.decodeByteArray(
            byteArray,
            0,
            byteArray.size
        )
    )
}