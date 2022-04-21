package com.gravitycode.sevensevenseven

import org.json.JSONArray

fun JSONArray.map(): Array<String> {
    val arrayList: ArrayList<String> = ArrayList(length())
    for (i in 0 until length()) {
        val str = get(i).toString()
        arrayList.add(i, str)
    }

    return arrayList.toTypedArray()
}