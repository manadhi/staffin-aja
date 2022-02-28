package com.udhipe.staffinaja.domain.blog

class BlogInteractor(private val blogRepository: IBlogRepository): BlogUseCase {
    var blogList = ArrayList<Blog>()

    override suspend fun getAllBlog(): List<Blog> {
        blogList.clear()
        blogList.addAll(blogRepository.getAllBlog())
        return blogList
    }

    override suspend fun getBlogById(id: Int): Blog? {
        var result: Blog? = null
        for (blog: Blog in blogList) {
            if (blog.id == id) {
                result = blog
            }
        }
        return result
    }
}