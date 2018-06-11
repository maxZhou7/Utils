package com.max.utils.common

import android.util.Log

/**
 * Created by max on 2017/11/22.
 */
object LogUtil {

    fun e(Tag: String, info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.e(Tag, infos.toString())
        }
    }

    fun d(Tag: String, info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.d(Tag, infos.toString())
        }
    }

    fun i(Tag: String, info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.i(Tag, infos.toString())
        }
    }

    fun w(Tag: String, info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.w(Tag, infos.toString())
        }
    }

    fun v(Tag: String, info: String) {
        if (Utils.isDebug()) {
            val infos = StringBuilder()
            infos.append(getFileLineMethod())
            infos.append(info)
            Log.v(Tag, infos.toString())
        }
    }

    private fun getFileLineMethod(): String {
        val traces = Throwable().stackTrace
        val traceElement = traces[2]
        val toStringBuffer = StringBuilder("[")
                .append(traceElement.fileName).append(" | ")
                .append(traceElement.lineNumber).append(" | ")
                .append(traceElement.methodName).append("()").append("]")
        return toStringBuffer.toString()
    }
}