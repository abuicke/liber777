package com.gravitycode.sevensevenseven.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.gravitycode.sevensevenseven.R

class HomeScreen(inflater: LayoutInflater) : Screen {

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.home_screen, null, false)

    val dropdownRows: Spinner = contentView.findViewById(R.id.dropdown_rows)
    val dropdownColumns: Spinner = contentView.findViewById(R.id.dropdown_columns)
    var onSearchEvent: ((String) -> Unit)? = null

    init {
        val searchField = contentView.findViewById<EditText>(R.id.field_search)
        contentView.findViewById<Button>(R.id.btn_search).setOnClickListener {
            onSearchEvent!!(searchField.text.toString())
        }
    }
}