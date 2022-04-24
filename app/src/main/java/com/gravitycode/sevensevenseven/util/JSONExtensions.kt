package com.gravitycode.sevensevenseven.util

import org.json.JSONArray

fun JSONArray.contains(str: String): Boolean {
    return jsonArrayContains(this, str)
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