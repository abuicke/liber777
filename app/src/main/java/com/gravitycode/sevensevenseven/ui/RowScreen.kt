package com.gravitycode.sevensevenseven.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gravitycode.sevensevenseven.Liber777
import com.gravitycode.sevensevenseven.R
import org.json.JSONArray

class RowScreen(context: Context, private val inflater: LayoutInflater) : Screen {

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.row_screen, null, false)
    private val recyclerView: RecyclerView = contentView.findViewById(R.id.recycler_view)

    init {
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun setRow(jsonArray: JSONArray) {
        recyclerView.adapter = Adapter(inflater, jsonArray)
    }
}

private class RowViewHolder(rowView: View) : RecyclerView.ViewHolder(rowView) {

    val label: TextView = rowView.findViewById(R.id.label)
    val text: TextView = rowView.findViewById(R.id.text)

}

private class Adapter(val inflater: LayoutInflater, val jsonArray: JSONArray) :
    RecyclerView.Adapter<RowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        return RowViewHolder(inflater.inflate(R.layout.row, parent, false))
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        holder.label.text = Liber777.COLUMN_NAMES[position]
        holder.text.text = jsonArray.getString(position)
    }

    override fun getItemCount(): Int = jsonArray.length()
}