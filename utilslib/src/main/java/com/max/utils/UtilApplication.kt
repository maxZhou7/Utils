package com.max.utils

import android.app.Application

abstract class UtilApplication : Application() {

    companion object {
        private var instance: Application? = null
        fun getInstatnce() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        init()
    }

    abstract fun init()
}