# Utils
It didn't have any complex arithmetic,just collect some useful things.<br>
This lib is wrote by kotlin.It contains some common utils,like doubleclick event,logutils and so on.I will add more later.I hope it will useful , even only one person.<br>
这是一个使用kotlin编写的lib库，目前包括有双击操作，日志打印等。后续会增加更多日常使用的工具，希望这能够有用处。<br>

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
	        implementation 'com.github.maxZhou7:Utils:0.0.4'
	}

Invoke:<br>

	使用时需要自己项目的application继承UtilApllicaion，如果项目是kotlin，需要在自己的application里面加上
	companion object {
		fun getInstatnce() = UtilApplication.getInstatnce()
	}
	这样便可以直接通过自己的application.getInstatnce()获取引用
	java里面可以在其他类里面调用到自己application的父类的getinstance()方法，所以不需添加

kotlin:<br>

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
	
	myDialog?.setDialogTitle("测试标题")
                        ?.setContent("这是一个很长的测试内容的条目，你说好不好呢？")
                        ?.setLeftBtn("取消")
                        ?.setRightBtn("确定")
                        ?.setBtnClick(object : DialogView.BtnClickListener {
                            override fun onLeftClick() {
                            }

                            override fun onRightClick() {
                            }
                        })
                        ?.show()
			
	
	<com.max.utils.widget.AverageTextView
        	android:layout_width="120dp"
        	android:layout_height="wrap_content"
        	app:av_text="就是要测试一下" />

java:<br>

	LogUtil.INSTANCE.e("test", "test value");
	其他的类似调用方式
	

#### v0.0.1
double click,logUtil,sharepreference

#### v0.0.2
add ResourceUtil,ScreenDisplay,Encrypt

#### v0.0.3
增加AverageTextView，主要用于固定长度下均分显示文字

#### v0.0.4
新增DialogView，一个比较常用的dialog，可以自定义title，content以及按钮数量和文字


