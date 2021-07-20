package com.cindodcindy.vieroshoesnew.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun String.validateEdittextEmpty(): Boolean {
    var isEmpty = false
    if (this.isEmpty()) {
        isEmpty = true
    }
    return isEmpty
}


fun showView(view: View) {
    view.visibility = View.VISIBLE
}

fun ImageView.loadImageUrl(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
