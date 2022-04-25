package com.gravitycode.sevensevenseven.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.get
import com.gravitycode.sevensevenseven.R

class RowScreen(inflater: LayoutInflater) : Screen {

    private companion object {
        private const val TEXT_VIEW_TAG = "text"
    }

    @SuppressLint("InflateParams")
    override val contentView: View = inflater.inflate(R.layout.row_screen, null, false)

    val rows: List<TextView> = findRows()

    private fun findRows(): List<TextView> {
        val rowsViewGroup: ViewGroup = contentView.findViewById(R.id.rows)
        val list = ArrayList<TextView>(rowsViewGroup.childCount / 4)
        rowsViewGroup.children.iterator().forEach { child ->
            if (child.tag == TEXT_VIEW_TAG) {
                list.add(child as TextView)
            }
        }

        return list
    }
}
