package com.max.utils

import android.os.Handler
import android.os.Message
import android.view.View
import java.util.*

/**
 * Created by max on 2017/11/22.
 */
class ViewClickManager : Handler.Callback {

    private val INTERVAL = 300//双击间隔时间 毫秒
    private val WHAT_CLICK = 1000

    //save the clickable view，and last click time fo views
    private val mViews = HashMap<Int, ArrayList<OnClickListener>>()
    private val mHandle = Handler(this)

    override fun handleMessage(msg: Message?): Boolean {
        when (msg?.what) {
            WHAT_CLICK -> {
                var temp = mViews[msg?.arg1] ?: return true
                if (temp != null && temp.size >= 2) {
                    //double click
                    temp[0].onDoubleClick()
                } else {
                    temp[0].onSingleClick()
                }
                mViews.remove(msg.arg1)
            }
        }
        return false
    }

    fun setClickLister(view: View?, lister: OnClickListener?) {
        if (view == null || lister == null) {
            throw NullPointerException("view or lister is null")
        }
        val id = view.id
        if (mViews.containsKey(id)) mViews.remove(id)
        view.setOnClickListener {
            val tempList: ArrayList<OnClickListener>
            if (mViews.containsKey(id)) {
                tempList = mViews[id] ?: ArrayList()
            } else {
                // this is first click
                tempList = ArrayList()

                val message = mHandle.obtainMessage(WHAT_CLICK)
                message.arg1 = id
                mHandle.sendMessageDelayed(message, INTERVAL.toLong())
            }
            tempList.add(lister)
            mViews.put(id, tempList)
        }
    }

    interface OnClickListener {
        fun onSingleClick()

        fun onDoubleClick()
    }
}