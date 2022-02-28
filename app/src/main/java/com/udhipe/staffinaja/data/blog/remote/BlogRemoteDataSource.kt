package com.udhipe.staffinaja.data.blog.remote

class BlogRemoteDataSource(private val blogWebService: BlogWebService): IBlogRemoteDataSource {
    override suspend fun getAllBlog(): List<BlogNetworkModel> {
        val response = blogWebService.getAllBlog()
        if (response.isSuccessful) {
            return response.body()?.results ?: ArrayList()
        } else {
            throw Exception("Sorry, an error occurred while requesting data, status error ${response.code()}")
        }
    }
}