package com.udhipe.staffinaja.domain.blog

interface IBlogRepository {
    suspend fun getAllBlog(): List<Blog>
}