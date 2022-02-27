package com.udhipe.staffinaja.domain.blog

import java.util.Date

data class Blog(
    val id: Int,
    val title: String,
    val subTitle: String,
    val cratedDate: Date,
    val image: String,
    val content: String,
    val tag: String,
    val author: String
)