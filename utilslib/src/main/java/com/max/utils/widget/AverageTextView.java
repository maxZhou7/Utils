package com.max.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.max.utils.common.LogUtil;
import com.max.utils.R;
import com.max.utils.common.ResourceUtil;


/**
 * Created by max on 2018/6/11
 */

public class AverageTextView extends View {

    //内容之外的高度
    private static int VIEW_HEIGHT = ResourceUtil.INSTANCE.getDimensionPixelOffset(R.dimen.dp6);

    private Paint mPaint;
    private int txtWidth, txtHeight;

    private float mTextSize;
    private int mTextColor;
    private String mText;
    private Rect rAll;//计算所有的text

    public AverageTextView(Context context) {
        super(context);
        init(context, null);
    }

    public AverageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AverageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.average_text);
        mTextSize = a.getDimension(R.styleable.average_text_av_textSize, ResourceUtil.INSTANCE.getDimensionPixelOffset(R.dimen.dp14));
        mTextColor = a.getColor(R.styleable.average_text_av_textColor, ResourceUtil.INSTANCE.getColor(R.color.color_666));
        mText = a.getString(R.styleable.average_text_av_text);
        mText = TextUtils.isEmpty(mText) ? "" : mText;
        a.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);

        rAll = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), rAll);
        txtWidth = rAll.width();//文字宽
        txtHeight = rAll.height();//文字高
    }

    /**
     * 文字内容以外的空隙高度，均分在上下
     *
     * @param dp
     */
    public void setViewOutHeight(int dp) {
        VIEW_HEIGHT = ResourceUtil.INSTANCE.getDimensionPixelOffset(dp);
        invalidate();
    }

    /**
     * 设置显示文字
     *
     * @param value
     */
    public void setText(String value) {
        this.mText = value;
        invalidate();
    }

    public void setTextColor(int textColor) {
        mTextColor = ResourceUtil.INSTANCE.getColor(textColor);
        invalidate();
    }

    public void setTextSize(int textSize) {
        mTextColor = ResourceUtil.INSTANCE.getDimensionPixelOffset(textSize);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, VIEW_HEIGHT + txtHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();//控件宽度
        int length = mText.length();//文字数量

        while (width < txtWidth && mText.length() >= 0) {
            mText = mText.substring(0, mText.length() - 1);
            mPaint.getTextBounds(mText, 0, mText.length(), rAll);
            txtWidth = rAll.width();
            length = mText.length();
        }
        if (width < txtWidth) {
            LogUtil.INSTANCE.e("onDraw", "too many words");
            return;//文字太多放不下
        }
        int drawBaseY = txtHeight + VIEW_HEIGHT / 2;
        int div = (width - txtWidth) / (length - 1);
        for (int i = 0; i < length; i++) {
            String temp = mText.substring(i, i + 1);
            String passString = mText.substring(0, i);
            Rect rect = new Rect();
            mPaint.getTextBounds(passString, 0, passString.length(), rect);
            int passWidth = rect.width() + div * i;
            canvas.drawText(temp, passWidth, drawBaseY - rAll.bottom, mPaint);
        }
    }
}

