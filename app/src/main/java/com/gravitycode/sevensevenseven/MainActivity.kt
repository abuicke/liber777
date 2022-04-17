package com.gravitycode.sevensevenseven

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonInputStream: InputStream = resources.openRawResource(R.raw.sevensevenseven)

        val bytes = ByteArray(jsonInputStream.available())
        jsonInputStream.read(bytes, 0, bytes.size)

        val jsonString = String(bytes)
        val jsonArray = JSONArray(jsonString)

        val row1 = jsonArray[1]
        Log.i("mojo", row1.toString())
    }
}