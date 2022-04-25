package com.gravitycode.sevensevenseven

import android.os.Bundle
import android.widget.TextView
import androidx.annotation.IntRange
import androidx.appcompat.app.AppCompatActivity
import com.google.common.base.Optional
import com.google.common.base.Preconditions
import com.gravitycode.sevensevenseven.ui.ColumnScreen
import com.gravitycode.sevensevenseven.ui.HomeScreen
import com.gravitycode.sevensevenseven.ui.RowScreen
import com.gravitycode.sevensevenseven.ui.Screen
import com.gravitycode.sevensevenseven.util.toastLong

@Suppress("MemberVisibilityCanBePrivate")
class MainActivity : AppCompatActivity() {

    private lateinit var homeScreen: HomeScreen
    private lateinit var rowScreen: RowScreen
    private lateinit var columnScreen: ColumnScreen

    private lateinit var liber777: Liber777

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        liber777 = Liber777(this)
        homeScreen = HomeScreen(layoutInflater)
        rowScreen = RowScreen(layoutInflater)
        columnScreen = ColumnScreen(layoutInflater)
//        setContentView(homeScreen)
        displayRow(2)

        homeScreen.dropdownRows.onItemSelectedListener = OnItemSelectedListener { position ->
            if (position > 0) {
                displayRow(position - 1)
            }
        }

        homeScreen.dropdownColumns.onItemSelectedListener = OnItemSelectedListener { position ->
            if (position > 0) {
                displayColumn(position - 1)
            }
        }

        homeScreen.onSearchEvent = { searchQuery ->
            val result: Optional<Int> = liber777.findRowContaining(searchQuery)
            if (result.isPresent) {
                displayRow(result.get())
            } else {
                toastLong("$searchQuery not found")
            }
        }
    }

    fun setContentView(screen: Screen) {
        super.setContentView(screen.contentView)
    }

    override fun onBackPressed() {
        setContentView(homeScreen.contentView)
    }

    fun displayRow(@IntRange(from = 0, to = Liber777.MAX_ROWS) index: Int) {
        Preconditions.checkArgument(index in 0..Liber777.MAX_ROWS, index)

        val row = liber777.getRow(index)
        rowScreen.textKey.text = row.getString(0)
        rowScreen.textHebrewNames.text = row.getString(1)
        rowScreen.textEnglishOfColII.text = row.getString(2)
        rowScreen.textConsciousnessOfTheAdept.text = row.getString(3)
        rowScreen.textGodNamesInAssiah.text = row.getString(4)
        rowScreen.textTheHeavensInAssiah.text = row.getString(5)

        setContentView(rowScreen)
    }

    fun displayColumn(@IntRange(from = 0, to = Liber777.MAX_COLUMNS) index: Int) {
        Preconditions.checkArgument(index in 0..Liber777.MAX_COLUMNS, index)
        columnScreen.contentView.findViewById<TextView>(R.id.text).text =
            liber777.getColumn(index).toString()
        setContentView(columnScreen)
    }
}