package com.udhipe.staffinaja.ui.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class PresenterModel {
    data class Candidate(
        val id: Int,
        val name: String,
        val image: String,
        val age: Int,
        val gender: String,
        val expired: Boolean
    ) : PresenterModel()

    @Parcelize
    data class Blog(
        val id: Int,
        val title: String,
        val subTitle: String,
        val content: String,
        val image: String,
        val createdDate: String,
        val tag: String,
        val author: String
    ) : PresenterModel(), Parcelable
}
