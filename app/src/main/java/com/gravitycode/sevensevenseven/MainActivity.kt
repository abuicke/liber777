package com.gravitycode.sevensevenseven

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var homeScreen: HomeScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeScreen = HomeScreen(layoutInflater)
        setContentView(homeScreen.contentView)

        val liber777 = Liber777(this)
        var columnNames: Array<String> = resources.getStringArray(R.array.columns)
        columnNames = columnNames.sliceArray(IntRange(1, columnNames.size - 1))

        homeScreen.dropdownRows.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                show(text, liber777.getRow(position - 1).map().zip(columnNames.asIterable()) { s1, s2 ->
                    "$s2: $s1"
                }) {
                    // show()
                }
            }
        }

        homeScreen.dropdownColumns.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                show(text, liber777.getColumn(position - 1).map()) {
                    // show()
                }
            }
        }
    }

    override fun onBackPressed() {
        setContentView(homeScreen.contentView)
    }

    private fun show(title: String, items: Array<String>, onClick: (Int) -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setItems(items) { _, which ->
            onClick(which)
        }
        builder.show()
    }
}