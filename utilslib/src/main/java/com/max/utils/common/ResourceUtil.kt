package com.max.utils.common

import android.graphics.drawable.Drawable
import java.util.*

object ResourceUtil {

    fun getString(id: Int): String {
        return UtilApplication.getInstatnce().resources.getString(id)
    }

    fun getString(id: Int, vararg objects: Objects): String {
        return UtilApplication.getInstatnce().resources.getString(id, objects)
    }

    fun getStringArray(id: Int): Array<String> {
        return UtilApplication.getInstatnce().resources.getStringArray(id)
    }

    fun getColor(id: Int): Int {
        return UtilApplication.getInstatnce().resources.getColor(id)
    }

    fun getDimensionPixelOffset(id: Int): Int {
        return UtilApplication.getInstatnce().resources.getDimensionPixelOffset(id)
    }

    fun getDrawable(id: Int): Drawable {
        return UtilApplication.getInstatnce().resources.getDrawable(id)
    }

    fun getDimensionPixelSize(id: Int): Int {
        return UtilApplication.getInstatnce().resources.getDimensionPixelSize(id)
    }

    fun getTextArray(id: Int): Array<CharSequence> {
        return UtilApplication.getInstatnce().resources.getTextArray(id)
    }

    fun getIntArray(id: Int): IntArray {
        return UtilApplication.getInstatnce().resources.getIntArray(id)
    }

}