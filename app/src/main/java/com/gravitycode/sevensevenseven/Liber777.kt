package com.gravitycode.sevensevenseven

import android.content.Context
import androidx.annotation.IntRange
import com.google.common.base.Optional
import com.google.common.base.Preconditions
import com.gravitycode.sevensevenseven.util.contains
import org.json.JSONArray
import java.io.InputStream

/**
 * TODO: Should be singleton
 * */
class Liber777(context: Context) {

    companion object {
        const val MAX_ROWS = 35L
        const val MAX_COLUMNS = 52L

        val COLUMN_NAMES = arrayOf(
            "Key Scale",
            "Hebrew Names of Numbers and Letters",
            "English of Col. II",
            "Consciousness of the Adept",
            "God-Names in Assiah",
            "The Heavens of Assiah",
            "English of Col. VI",
            "Orders of Qliphoth"
        )
    }

    private val columns: JSONArray
    private val rows: JSONArray

    init {
        columns = loadJson(context)
        rows = swapAxes(columns)
    }

    private fun loadJson(context: Context): JSONArray {
        val jsonInputStream: InputStream = context.resources.openRawResource(R.raw.liber777)

        val bytes = ByteArray(jsonInputStream.available())
        jsonInputStream.read(bytes, 0, bytes.size)

        val jsonString = String(bytes)
        return JSONArray(jsonString)
    }

    private fun swapAxes(jsonArray: JSONArray): JSONArray {
        val newJsonArray = JSONArray()
        for (col in 0 until jsonArray.length()) {
            val column = jsonArray.get(col) as JSONArray
            for (row in 0 until column.length()) {
                if (newJsonArray.isNull(row)) {
                    newJsonArray.put(row, JSONArray())
                }

                newJsonArray.getJSONArray(row).put(column.get(row))
            }
        }
        return newJsonArray
    }

    fun getRow(@IntRange(from = 0, to = MAX_ROWS) index: Int): JSONArray {
        Preconditions.checkArgument(index in 0..MAX_ROWS, index)
        return rows.getJSONArray(index)
    }

    fun getColumn(@IntRange(from = 0, to = MAX_COLUMNS) index: Int): JSONArray {
        Preconditions.checkArgument(index in 0..MAX_COLUMNS, index)
        return columns.getJSONArray(index)
    }

    fun get(
        @IntRange(from = 0, to = MAX_COLUMNS) col: Int,
        @IntRange(from = 0, to = MAX_ROWS) row: Int
    ): String {
        Preconditions.checkArgument(col in 0..MAX_COLUMNS, col)
        Preconditions.checkArgument(row in 0..MAX_ROWS, row)
        return columns.get(row).toString()
    }

    fun findRowContaining(str: String): Optional<Int> {
        for (i in 0 until rows.length()) {
            val column = rows.getJSONArray(i)
            if (column.contains(str)) {
                return Optional.of(i)
            }
        }

        return Optional.absent()
    }
}