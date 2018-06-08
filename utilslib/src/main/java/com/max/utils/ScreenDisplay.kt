package com.max.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

object ScreenDisplay {

    fun getScreenWidth(context: Context): Int {
        val manager = (context as Activity).windowManager
        val outMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        val manager = (context as Activity).windowManager
        val outMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }

    fun dp2px(dpValue: Float): Int {
        val scale = UtilApplication.getInstatnce().resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dip(pxValue: Float): Int {
        val scale = UtilApplication.getInstatnce().resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun sp2px(spValue: Float): Int {
        val scale = UtilApplication.getInstatnce().resources.displayMetrics.scaledDensity
        return (spValue * scale + 0.5f).toInt()
    }

    fun px2sp(pxValue: Float): Int {
        val scale = UtilApplication.getInstatnce().resources.displayMetrics.scaledDensity
        return (pxValue / scale + 0.5f).toInt()
    }
}