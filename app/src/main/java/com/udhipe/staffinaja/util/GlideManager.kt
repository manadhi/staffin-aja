package com.udhipe.staffinaja.util

import android.content.Context
import android.view.RoundedCorner
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.udhipe.staffinaja.R

object GlideManager {
    fun loadImageResource(context: Context, resource: String, target: ImageView) {
        Glide.with(context)
            .load(resource)
            .centerCrop()
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
            .error(R.drawable.ic_round_broken_image_24)
            .into(target)
    }
}