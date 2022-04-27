package com.gravitycode.sevensevenseven.util

import org.json.JSONArray
import org.json.JSONObject

fun JSONArray.contains(str: String): Boolean {
    return jsonArrayContains(this, str)
}

/**
 * @return `fallback` if the value at `index` is either `null` or [JSONObject.NULL]
 * */
fun JSONArray.getString(index: Int, fallback: String): String {
    val str: Any? = get(index)
    return if (str == JSONObject.NULL || str == null) fallback else str.toString()
}

fun jsonArrayContains(jsonArray: JSONArray, str: String): Boolean {
    for (i in 0 until jsonArray.length()) {
        val obj = jsonArray.get(i)
        if (obj is JSONArray) {
            jsonArrayContains(obj, str)
        } else if (obj.toString() == str) {
            return true
        }
    }

    return false
}