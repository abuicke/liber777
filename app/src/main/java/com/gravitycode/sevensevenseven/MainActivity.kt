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

        val json: JSONArray = loadJson()

        binding.dropdownRows.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                toastShort(parent!!.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.dropdownColumns.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                toastShort(parent!!.getItemAtPosition(position).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    private fun loadJson(): JSONArray {
        val jsonInputStream: InputStream = resources.openRawResource(R.raw.sevensevenseven)

        val bytes = ByteArray(jsonInputStream.available())
        jsonInputStream.read(bytes, 0, bytes.size)

        val jsonString = String(bytes)
        return JSONArray(jsonString)
    }
}