package com.udhipe.staffinaja.ui.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udhipe.staffinaja.R
import com.udhipe.staffinaja.databinding.ActivityBlogBinding
import com.udhipe.staffinaja.ui.home.PresenterModel
import com.udhipe.staffinaja.util.GlideManager

class BlogActivity : AppCompatActivity() {
    companion object {
        const val BLOG_ID = "blog_id"
        const val BLOG_DATA = "blog_presenter_model"
    }

    private lateinit var binding: ActivityBlogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
    }

    private fun setView() {
        val blogPresenterModel = intent.getParcelableExtra<PresenterModel.Blog>(BLOG_DATA)

        if (blogPresenterModel != null) {
            binding.tvBlogTitle.text = blogPresenterModel.title
            GlideManager.loadImageResource(
                this@BlogActivity,
                blogPresenterModel.image,
                binding.imgBlog
            )
            val allContent = blogPresenterModel.subTitle + " " + blogPresenterModel.content
            binding.tvBlogContent.text = allContent
            binding.tvBlogTag.text = resources.getString(
                R.string.blog_tag, blogPresenterModel.tag
            )
            binding.tvBlogAuthor.text = getString(R.string.blog_author, blogPresenterModel.author)
            binding.tvBlogCreatedDate.text =
                getString(R.string.blog_created_at, blogPresenterModel.createdDate)
        }
    }
}