package com.amaglovany.ktx

import android.os.Build
import android.view.View
import android.view.ViewOutlineProvider
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

fun View.enableBoundsOutline(enable: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        outlineProvider = if (enable) {
            ViewOutlineProvider.PADDED_BOUNDS
        } else ViewOutlineProvider.BACKGROUND
    }
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) = changeVisibility(value)

fun View.changeVisibility(visible: Boolean, invisibleState: Int = View.GONE) {
    visibility = if (visible) View.VISIBLE else invisibleState
}


val TextView.textString: String? get() = text?.toString()

fun InputMethodManager.hideSoftInputFrom(view: View?) {
    hideSoftInputFromWindow(view?.windowToken ?: return, 0)
}