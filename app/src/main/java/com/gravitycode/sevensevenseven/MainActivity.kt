package com.gravitycode.sevensevenseven

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gravitycode.sevensevenseven.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var lookupView: LookupView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        lookupView = LookupView(this)

        setContentView(binding.root)

        val liber777 = Liber777(this)

        binding.dropdownRows.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle(text)
                builder.setItems(liber777.getRow(position - 1).map()) { dialog, which ->
                    // TODO: Open LookupView here
                }
                builder.show()
            }
        }

        binding.dropdownColumns.onItemSelectedListener = OnItemSelectedListener { text, position ->
            if (position > 0) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle(text)
                builder.setItems(liber777.getColumn(position - 1).map()) { dialog, which ->
                    // TODO: Open LookupView here
                }
                builder.show()
            }
        }
    }
}