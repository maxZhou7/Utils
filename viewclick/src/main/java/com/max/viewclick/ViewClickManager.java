package com.max.viewclick;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by max on 2017/11/21.
 *
 * @email maxzhou7@gmail.com
 */

public class ViewClickManager implements Handler.Callback {

    public interface OnClickListener {
        void onSingleClick();

        void onDoubleClick();
    }

    private static final int INTERVAL = 300;//双击间隔时间 毫秒
    private static final int WHAT_CLICK = 1000;

    private HashMap<Integer, ArrayList<OnClickListener>> mViews;//save the clickable view，and last click time fo views
    private Handler mHandle;

    public ViewClickManager() {
        //init somethings
        mViews = new HashMap<>();
        mHandle = new Handler(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what == WHAT_CLICK) {
            ArrayList<OnClickListener> tt = mViews.get(msg.arg1);
            if (tt == null) return true;
            if (tt != null && tt.size() >= 2) {
                //double click
                tt.get(0).onDoubleClick();
            } else {
                tt.get(0).onSingleClick();
            }
            mViews.remove(msg.arg1);
        }
        return false;
    }

    public void setClickLister(final View view, final OnClickListener lister) {
        if (view == null || lister == null) {
            throw new NullPointerException("view or lister is null");
        }
        final int id = view.getId();
        if (mViews.containsKey(id)) mViews.remove(id);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<OnClickListener> tempList;
                if (mViews.containsKey(id)) {
                    tempList = mViews.get(id);
                } else {
                    // this is first click
                    tempList = new ArrayList<>();

                    Message message = mHandle.obtainMessage(WHAT_CLICK);
                    message.arg1 = id;
                    mHandle.sendMessageDelayed(message, INTERVAL);
                }
                tempList.add(lister);
                mViews.put(id, tempList);
            }
        });
    }
}
