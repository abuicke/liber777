package com.gravitycode.sevensevenseven

import android.view.View
import android.widget.AdapterView

class OnItemSelectedListener(
    private val onItemSelected: (String) -> Unit
) : AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        onItemSelected(parent!!.getItemAtPosition(position).toString())
    }

    override fun onNothingSelected(parent: AdapterView<*>?) = Unit
}