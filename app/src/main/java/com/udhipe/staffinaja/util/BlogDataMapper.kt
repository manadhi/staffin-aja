package com.udhipe.staffinaja.util

import com.udhipe.staffinaja.data.blog.remote.BlogNetworkModel
import com.udhipe.staffinaja.domain.blog.Blog
import com.udhipe.staffinaja.ui.home.PresenterModel
import java.util.*
import kotlin.collections.ArrayList

object BlogDataMapper {
    fun mapBlogNetworkModelToDomain(input: List<BlogNetworkModel>): List<Blog> {
        val blogList = ArrayList<Blog>()
        input.map {
            val blog = Blog(
                id = it.id,
                title = it.title,
                subTitle = it.subTitle,
                createdDate = Date(it.createdAt),
                image = it.photo,
                content = it.content,
                tag = it.tag,
                author = it.author
            )
            blogList.add(blog)
        }
        return blogList
    }

    fun mapBlogDomainModelToPresenter(input: List<Blog>): List<PresenterModel.Blog> {
        val blogList = ArrayList<PresenterModel.Blog>()
        input.map {
            val blog = PresenterModel.Blog(
                id = it.id,
                title = it.title,
                subTitle = it.subTitle,
                image = it.image,
                content = it.content,
                author = it.author,
                createdDate = DateManipulator.convertDateToString(it.createdDate, "d MMMM yyyy"),
                tag = it.tag
            )
            blogList.add(blog)
        }
        return blogList
    }
}