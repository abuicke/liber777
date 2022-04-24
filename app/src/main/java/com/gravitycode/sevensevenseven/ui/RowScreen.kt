package com.gravitycode.sevensevenseven.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import com.gravitycode.sevensevenseven.R

class RowScreen(inflater: LayoutInflater) : Screen {

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.row_screen, null, false)
}
