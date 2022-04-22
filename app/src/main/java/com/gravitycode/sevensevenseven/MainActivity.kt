package com.gravitycode.sevensevenseven

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gravitycode.sevensevenseven.databinding.MainActivityBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val liber777 = Liber777(this)
        var columnNames: Array<String> = resources.getStringArray(R.array.columns)
        columnNames = columnNames.sliceArray(IntRange(1, columnNames.size - 1))

        binding.dropdownRows.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                show(text, liber777.getRow(position - 1).map().zip(columnNames.asIterable()) { s1, s2 ->
                    "$s2: $s1"
                }) {
                    // show()
                }
            }
        }

        binding.dropdownColumns.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                show(text, liber777.getColumn(position - 1).map()) {
                    // show()
                }
            }
        }
    }

    override fun onBackPressed() {
        setContentView(binding.root)
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