package com.gravitycode.sevensevenseven.util

object Preconditions {

    fun checkArgument(expression: Boolean, errorMessage: Any) {
        if (!expression) {
            throw IllegalArgumentException(errorMessage.toString())
        }
    }
}
