package com.max.utils.widget

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import com.max.utils.R
import kotlinx.android.synthetic.main.layout_dialog.*

/**
 * 通用弹出框
 * 默认显示一个确认按钮
 */
class DialogView(context: Context) : Dialog(context, R.style.FullScreenDialog) {

    init {
        setContentView(R.layout.layout_dialog)
        initWindow()
    }

    private fun initWindow() {
        val window = window
        val lp = window!!.attributes
        window.attributes = lp
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT
        window.setWindowAnimations(R.style.scale)
        onWindowAttributesChanged(lp)
        window.setBackgroundDrawableResource(android.R.color.transparent) // 透明，避免黑色背景框
    }

    fun setDialogTitle(string: String): DialogView {
        title.text = string
        if (!TextUtils.isEmpty(title.text.toString())) {
            title.visibility = View.VISIBLE
        } else {
            title.visibility = View.GONE
        }
        return this
    }

    fun setContent(string: String): DialogView {
        content.text = string
        return this
    }

    fun setLeftBtn(string: String): DialogView {
        if (!TextUtils.isEmpty(string)) {
            leftBtn.text = string
            leftBtn.visibility = View.VISIBLE
        } else {
            leftBtn.text = ""
            leftBtn.visibility = View.GONE
        }
        setOneOrTwoBtn()
        return this
    }

    fun setRightBtn(string: String): DialogView {
        if (!TextUtils.isEmpty(string)) {
            rightBtn.text = string
            rightBtn.visibility = View.VISIBLE
        } else {
            rightBtn.text = ""
            rightBtn.visibility = View.GONE
        }

        setOneOrTwoBtn()
        return this
    }

    fun setBtnClick(onBtnClickLister: BtnClickListener): DialogView {
        if (onBtnClickLister != null) {
            leftBtn.setOnClickListener { v ->
                run {
                    onBtnClickLister.onRightClick()
                    dismiss()
                }
            }
            rightBtn.setOnClickListener { v ->
                run {
                    onBtnClickLister.onLeftClick()
                    dismiss()
                }
            }
        } else {
            rightBtn.setOnClickListener { v ->
                run {
                    dismiss()
                }
            }
        }
        return this
    }

    private fun setOneOrTwoBtn() {
        if (isAllBtnExit()) {
            divider.visibility = View.VISIBLE
            empty1.visibility = View.GONE
            empty2.visibility = View.GONE
        } else {
            divider.visibility = View.GONE
            empty1.visibility = View.VISIBLE
            empty2.visibility = View.VISIBLE
        }
    }

    /**
     * 判断是否两个按钮都存在
     */
    private fun isAllBtnExit(): Boolean {
        if (!TextUtils.isEmpty(leftBtn.text.toString()) && !TextUtils.isEmpty(rightBtn.text.toString())) {
            return true
        }
        return false
    }

    interface BtnClickListener {
        fun onLeftClick()
        fun onRightClick()
    }
}