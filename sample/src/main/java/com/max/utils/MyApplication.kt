package com.max.utils

import com.max.utils.common.UtilApplication

class MyApplication : UtilApplication() {

    companion object {
        fun getInstatnce() = UtilApplication.getInstatnce()
    }

    override fun init() {
    }

}