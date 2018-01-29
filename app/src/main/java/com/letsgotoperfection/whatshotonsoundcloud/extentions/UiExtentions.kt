package com.letsgotoperfection.whatshotonsoundcloud.extentions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author hossam.
 */
fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun ImageView.loadUrl(url: String) {
    Glide.with(context.applicationContext).load(url).into(this)
}
