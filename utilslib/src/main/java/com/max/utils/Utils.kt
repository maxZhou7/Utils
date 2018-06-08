package com.max.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.widget.Toast
import java.util.regex.Pattern

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

    fun getVersionName(context: Context): String {
        return getPackageInfo(context)!!.versionName
    }

    fun getVersionCode(context: Context): Int {
        return getPackageInfo(context)!!.versionCode
    }

    /**
     * 特殊字符过滤,过滤各种标点等符号
     */
    fun stringFilter(str: String): String {
        val regEx = "[/\\:*?<>|~@#￥%……&*（）“”‘’''，。《》|()?？=、；·}{——+\"\n\t]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(str)
        return m.replaceAll("")
    }

    private fun getPackageInfo(context: Context): PackageInfo? {
        var pi: PackageInfo? = null
        try {
            val pm = context.packageManager
            pi = pm.getPackageInfo(context.packageName, PackageManager.GET_CONFIGURATIONS)

            return pi
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return pi
    }
}