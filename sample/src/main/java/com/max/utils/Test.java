package com.max.utils;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by max on 2017/11/23.
 */

public class Test extends Activity {

    SPManager spManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spManager = new SPManager(this, "key", "nothing");
    }
}
