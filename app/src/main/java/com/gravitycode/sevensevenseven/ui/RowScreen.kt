package com.gravitycode.sevensevenseven.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.gravitycode.sevensevenseven.R

class RowScreen(inflater: LayoutInflater) : Screen {

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.row_screen, null, false)

    val textKey: TextView = contentView.findViewById(R.id.text_key)
    val textHebrewNames: TextView = contentView.findViewById(R.id.text_hebrew_names)
    val textEnglishOfColII: TextView = contentView.findViewById(R.id.text_english_of_col_II)
    val textConsciousnessOfTheAdept: TextView = contentView.findViewById(R.id.text_consciousness_of_the_adept)
    val textGodNamesInAssiah: TextView = contentView.findViewById(R.id.text_god_names_in_assiah)
}
