package com.armboldmind.gsport.presentation.helpers

import android.widget.ImageView
import com.armboldmind.gsport.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

fun ImageView.asyncLoadImage(url: String, roundingRadius: Int) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_basketball)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius)))
        .into(this)
}