package com.udhipe.staffinaja.domain.blog

interface BlogUseCase {
    suspend fun getAllBlog(): List<Blog>

    suspend fun getBlogById(id: Int): Blog?
}