package com.gravitycode.sevensevenseven

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.gravitycode.sevensevenseven.databinding.MainActivityBinding
import org.json.JSONArray
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var lookupView: LookupView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        lookupView = LookupView(this)

        setContentView(binding.root)

        val liber777 = Liber777(this)

        binding.dropdownRows.onItemSelectedListener = OnItemSelectedListener { text ->
            toastShort(text)
        }

        binding.dropdownColumns.onItemSelectedListener = OnItemSelectedListener { text ->
            toastShort(text)
        }
    }
}