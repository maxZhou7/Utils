# Utils
collect some common util.It contain doubleclick event for view.<br>
目前android上存在一些环境需要用到双击的操作，为便于使用，故用极简单的方式实现了一个对View双击的操作。

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
	        compile 'com.github.maxZhou7:Utils:1.0'
	}

Invoke:<br>

 	ViewClickManager viewClickManager;
 	viewClickManager.setClickLister(btn1, new ViewClickManager.OnClickListener() {
            @Override
            public void onSingleClick() {
                toast("btn1 single click");
            }

            @Override
            public void onDoubleClick() {
                toast("btn1 double click");
            }
        });
        viewClickManager.setClickLister(btn2, new ViewClickManager.OnClickListener() {
            @Override
            public void onSingleClick() {
                toast("btn2 single click");
            }

            @Override
            public void onDoubleClick() {
                toast("btn2 double click");
            }
        });

