package com.gravitycode.sevensevenseven

import android.view.View
import android.widget.AdapterView

class OnItemSelectedListener(
    private val onItemSelected: (String, Int) -> Unit
) : AdapterView.OnItemSelectedListener {

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        onItemSelected(parent!!.getItemAtPosition(position).toString(), position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) = Unit
}