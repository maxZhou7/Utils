package com.max.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by max on 2017/11/22.
 */
object Utils {

    private var IS_DEBUG: Boolean = true

    fun setDebug(isDebug: Boolean) {
        IS_DEBUG = isDebug
    }

    fun isDebug(): Boolean {
        return IS_DEBUG
    }

    fun toast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}