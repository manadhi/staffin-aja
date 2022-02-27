package com.udhipe.staffinaja.data.blog.remote

import com.udhipe.staffinaja.domain.blog.Blog

class BlogRemoteDataSource: IBlogRemoteDataSource {
    override suspend fun getAllBlog(): List<Blog> {
        TODO("Not yet implemented")
    }
}