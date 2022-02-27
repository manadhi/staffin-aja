package com.udhipe.staffinaja.data.blog.remote

import com.udhipe.staffinaja.domain.blog.Blog

interface IBlogRemoteDataSource {
    suspend fun getAllBlog(): List<Blog>
}
