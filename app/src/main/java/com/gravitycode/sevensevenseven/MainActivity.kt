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

        binding.dropdownRows.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                show(text, liber777.getRow(position - 1)) {
                    // show()
                }
            }
        }

        binding.dropdownColumns.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                show(text, liber777.getColumn(position - 1)) {
                    // show()
                }
            }
        }
    }

    private fun show(title: String, jsonArray: JSONArray, onClick: (Int) -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setItems(jsonArray.map()) { _, which ->
            onClick(which)
        }
        builder.show()
    }
}