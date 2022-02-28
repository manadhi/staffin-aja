package com.udhipe.staffinaja.data.blog

import com.udhipe.staffinaja.data.blog.remote.IBlogRemoteDataSource
import com.udhipe.staffinaja.domain.blog.Blog
import com.udhipe.staffinaja.domain.blog.IBlogRepository
import com.udhipe.staffinaja.util.BlogDataMapper

class BlogRepository(private val blogRemoteDataSource: IBlogRemoteDataSource) : IBlogRepository {
    override suspend fun getAllBlog(): List<Blog> {
        return BlogDataMapper.mapBlogNetworkModelToDomain(blogRemoteDataSource.getAllBlog())
    }
}