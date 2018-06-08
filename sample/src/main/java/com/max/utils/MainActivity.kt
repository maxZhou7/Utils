package com.max.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val tag = this@MainActivity.javaClass.simpleName
    private val viewClickManager = ViewClickManager()

    var value by SPManager(this@MainActivity, "key", "nothing")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //用于是否打印log。同时可扩展更多用处
        Utils.setDebug(true)
        //使用时需要继承UtilApplication或在manifest里面的application的name标为UtilApplication
        MyApplication.getInstatnce()
        //Encrypt中包含了几种常用的加密方法 md5 sha1 sha512 sha256
        //LogUtil用于打印各种类型的日志
        LogUtil.e(tag, Encrypt.md5("test"))
        //ResourceUtil获取资源文件里面的内容
        ResourceUtil.getString(R.string.app_name)
        //ScreenDisplay用于单位转换 获取屏幕尺寸
        ScreenDisplay.dp2px(10f)
        //sharepreference的使用通过SPManager
        val temp by SPManager(this@MainActivity, "key", "default")
        LogUtil.e(tag, temp)

        viewClickManager.setClickLister(btn1, object : ViewClickManager.OnClickListener {
            override fun onSingleClick() {
                LogUtil.d(tag, "btn1 single click")
                value = "btn1 single click"
                Utils.toast(this@MainActivity, value)
            }

            override fun onDoubleClick() {
                Utils.toast(this@MainActivity, "btn1 double click:" + value)
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
