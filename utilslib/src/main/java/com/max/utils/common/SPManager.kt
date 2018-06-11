package com.max.utils.common

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Created by max on 2017/11/23.
 * sharepreference manager
 *
 */
class SPManager<T>(context: Context, val name: String, val default: T) {

    private val prefs: SharedPreferences by lazy { context.getSharedPreferences("MY_SP", Context.MODE_PRIVATE) }

    operator fun getValue(thisPre: Any?, property: KProperty<*>): T {
        return getSharePreference(name, default)
    }

    operator fun setValue(thisPre: Any?, property: KProperty<*>, value: T) {
        putSharePreference(name, value)
    }

    private fun getSharePreference(name: String, default: T): T = with(prefs) {
        var res: Any = when (default) {
            is Long -> getLong(name, default)
            is Int -> getInt(name, default)
            is String -> getString(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw  IllegalArgumentException("not support")
        }
        return res as T
    }

    private fun putSharePreference(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is Int -> putInt(name, value)
            is String -> putString(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("not support")
        }.apply()
    }
}