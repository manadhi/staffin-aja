package com.udhipe.staffinaja.data.blog.remote

import com.google.gson.annotations.SerializedName

data class BlogNetworkModel(
    val id: Int,
    val title: String,
    val subTitle: String,
    val photo: String,
    val content: String,
    val author: String,
    @SerializedName("create_at") val createdAt: Long,
    val tag: String
)