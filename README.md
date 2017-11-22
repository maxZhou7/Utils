# Utils
It didn't have any complex arithmetic,just collect some useful things.<br>
This lib is wrote by kotlin.It contains some common utils,like doubleclick event,logutils and so on.I will add more later.I hope it will useful , even only one person.<br>
这是一个使用kotlin编写的lib库，目前包括有双击操作，日志打印。后续会增加更多日常使用的工具，希望这能够有用处。<br>

#### Usage：

Step 1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        compile 'com.github.maxZhou7:Utils:0.0.1'
	}

Invoke:<br>
	
	LogUtil.setDebug(true)
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

