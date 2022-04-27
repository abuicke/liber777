package com.gravitycode.sevensevenseven.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gravitycode.sevensevenseven.R
import com.gravitycode.sevensevenseven.util.Strings
import com.gravitycode.sevensevenseven.util.getString
import org.json.JSONArray

class ColumnScreen(context: Context, private val inflater: LayoutInflater) : Screen {

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.column_screen, null, false)
    private val recyclerView: RecyclerView = contentView.findViewById(R.id.recycler_view)

    init {
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun setColumn(jsonArray: JSONArray) {
        recyclerView.adapter = ColumnAdapter(inflater, jsonArray)
    }
}

private class ColumnViewHolder(rowView: View) : RecyclerView.ViewHolder(rowView) {

    val label: TextView = rowView.findViewById(R.id.label)
    val text: TextView = rowView.findViewById(R.id.text)
}

private class ColumnAdapter(val inflater: LayoutInflater, val jsonArray: JSONArray) :
    RecyclerView.Adapter<ColumnViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColumnViewHolder {
        return ColumnViewHolder(inflater.inflate(R.layout.column, parent, false))
    }

    override fun onBindViewHolder(holder: ColumnViewHolder, position: Int) {
        holder.label.text = position.toString()
        holder.text.text = jsonArray.getString(position, Strings.EMPTY)
    }

    override fun getItemCount(): Int = jsonArray.length()
}
