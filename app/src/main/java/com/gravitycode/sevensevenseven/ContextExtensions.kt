package com.gravitycode.sevensevenseven

import android.content.Context
import android.widget.Toast

fun Context.toastShort(msg: CharSequence) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.toastLong(msg: CharSequence) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}