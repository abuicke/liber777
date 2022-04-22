package com.gravitycode.sevensevenseven

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.Spinner

class HomeScreen(inflater: LayoutInflater) : Screen {

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.home_screen, null, false)

    val dropdownRows: Spinner = contentView.findViewById(R.id.dropdown_rows)
    val dropdownColumns: Spinner = contentView.findViewById(R.id.dropdown_columns)
}