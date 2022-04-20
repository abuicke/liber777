package com.gravitycode.sevensevenseven

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

class LookupView(context: Context) : FrameLayout(context) {

    private val contentView: View = LayoutInflater.from(context)
        .inflate(R.layout.lookup_view, this, true)

    val textView: TextView = contentView.findViewById(R.id.text)
}