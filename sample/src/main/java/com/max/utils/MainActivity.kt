package com.max.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = this@MainActivity.javaClass.simpleName
    private val viewClickManager = ViewClickManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Utils.setDebug(true)

        viewClickManager.setClickLister(btn1, object : ViewClickManager.OnClickListener {
            override fun onSingleClick() {
                Utils.toast(this@MainActivity, "btn1 single click")
                LogUtil.d(tag, "btn1 single click")
            }

            override fun onDoubleClick() {
                Utils.toast(this@MainActivity, "btn1 double click")
                LogUtil.d(tag, "btn1 double click")
            }
        })
        viewClickManager.setClickLister(btn2, object : ViewClickManager.OnClickListener {
            override fun onSingleClick() {
                Utils.toast(this@MainActivity, "btn2 single click")
                LogUtil.d(tag, "btn2 single click")
            }

            override fun onDoubleClick() {
                Utils.toast(this@MainActivity, "btn2 double click")
                LogUtil.d(tag, "btn2 double click")
            }
        })
    }

}
