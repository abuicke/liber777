package com.gravitycode.sevensevenseven

import android.view.View
import android.widget.AdapterView

class OnItemSelectedListener(
    private val onItemSelected: (Int) -> Unit
) : AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        onItemSelected(position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) = Unit
}