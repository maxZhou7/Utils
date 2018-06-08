package com.max.utils

class MyApplication : UtilApplication() {

    companion object {
        fun getInstatnce() = UtilApplication.getInstatnce()
    }

    override fun init() {
    }

}