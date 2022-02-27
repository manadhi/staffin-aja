package com.udhipe.staffinaja.ui.blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udhipe.staffinaja.R

class BlogActivity : AppCompatActivity() {
    companion object {
        const val BLOG_ID = "blog_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)
    }
}