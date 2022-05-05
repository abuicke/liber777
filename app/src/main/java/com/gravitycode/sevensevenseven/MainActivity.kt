package com.gravitycode.sevensevenseven

import android.app.AlertDialog
import android.os.Bundle
import androidx.annotation.IntRange
import androidx.appcompat.app.AppCompatActivity
import com.gravitycode.sevensevenseven.ui.ColumnScreen
import com.gravitycode.sevensevenseven.ui.HomeScreen
import com.gravitycode.sevensevenseven.ui.RowScreen
import com.gravitycode.sevensevenseven.ui.Screen
import com.gravitycode.sevensevenseven.util.Preconditions
import com.gravitycode.sevensevenseven.util.toastLong

/**
 * TODO: Landscape changed is broken
 * TODO: Add option to write JSON to local disk and read [Liber777] from there so the user can edit it.
 * TODO: Add path name to [ColumnScreen] labels
 * TODO: Fix Arabic characters
 * TODO: Fix Greek characters
 * TODO: Search button should appear above soft keyboard when typing search
 * */
@Suppress("MemberVisibilityCanBePrivate")
class MainActivity : AppCompatActivity() {

    lateinit var homeScreen: HomeScreen
    lateinit var rowScreen: RowScreen
    lateinit var columnScreen: ColumnScreen

    lateinit var liber777: Liber777

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        liber777 = Liber777(this)
        homeScreen = HomeScreen(layoutInflater)
        rowScreen = RowScreen(this, layoutInflater)
        columnScreen = ColumnScreen(this, layoutInflater)
        setContentView(homeScreen)

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
            val result: List<Liber777.Item> = liber777.find(searchQuery, ignoreCase = true)
            when (result.size) {
                0 -> toastLong("$searchQuery not found")
                1 -> displayRow(result[0].row)
                else -> displaySearchResults(result)
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
        rowScreen.setRow(row)
        setContentView(rowScreen)
    }

    fun displayColumn(@IntRange(from = 0, to = Liber777.MAX_COLUMNS) index: Int) {
        Preconditions.checkArgument(index in 0..Liber777.MAX_COLUMNS, index)
        val col = liber777.getColumn(index)
        columnScreen.setColumn(col)
        setContentView(columnScreen)
    }

    private fun displaySearchResults(searchResults: List<Liber777.Item>) {
        val formattedSearchResults: Array<String> = searchResults.map { result ->
            "Row ${result.row} in ${Liber777.COLUMN_NAMES[result.col]}"
        }.toTypedArray()

        AlertDialog.Builder(this)
            .setTitle("Multiple Results Found")
            .setItems(formattedSearchResults) { _, which ->
                displayRow(searchResults[which].row)
            }
            .show()
    }
}