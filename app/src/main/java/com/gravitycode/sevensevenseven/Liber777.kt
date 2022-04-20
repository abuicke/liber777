package com.gravitycode.sevensevenseven

import android.content.Context
import android.util.Log
import androidx.annotation.IntRange
import com.google.common.base.Preconditions
import org.json.JSONArray
import java.io.InputStream

class Liber777(context: Context) {

    companion object {
        const val MAX_ROWS = 35L
        const val MAX_COLUMNS = 52L
    }

    private val columns: JSONArray
    private val rows: JSONArray

    init {
        columns = loadJson(context)
        rows = swapAxes(columns)
    }

    private fun loadJson(context: Context): JSONArray {
        val jsonInputStream: InputStream = context.resources.openRawResource(R.raw.sevensevenseven)

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
                if (column.isNull(row)) {
                    newJsonArray.put(row, JSONArray())
                }

//                (column.get(row) as JSONArray).put()

                Log.i("mojo", "get row $row in column $col ${column.get(row)}")
            }
        }
        return newJsonArray
    }

    fun getRow(@IntRange(from = 0, to = MAX_ROWS) index: Int): String {
        Preconditions.checkArgument(index in 0..MAX_ROWS)
        return rows[index].toString()
    }

    fun getColumn(@IntRange(from = 0, to = MAX_COLUMNS) index: Int): String {
        Preconditions.checkArgument(index in 0..MAX_COLUMNS)
        return columns[index].toString()
    }

}