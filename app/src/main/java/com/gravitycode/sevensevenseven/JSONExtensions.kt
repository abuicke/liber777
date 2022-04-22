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

fun Array<String>.zip(iterable: Iterable<String>, transform: (String, String) -> String): Array<String> {
    val newArray = ArrayList<String>(size)
    val thisIter = iterator()
    val thatIter = iterable.iterator()
    while (thisIter.hasNext() && thatIter.hasNext()) {
        newArray.add(transform(thisIter.next(), thatIter.next()))
    }

    return newArray.toTypedArray()
}