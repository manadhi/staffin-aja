package com.udhipe.staffinaja.data.blog.remote

import retrofit2.Response
import retrofit2.http.GET

interface BlogWebService {
    @GET("blogs")
    suspend fun getAllBlog(): Response<BlogResponse>
}