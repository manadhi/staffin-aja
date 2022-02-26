package com.udhipe.staffinaja.ui.home

sealed class PresenterModel {
    data class Candidate(
        val id: Int,
        val name: String,
        val image: String,
        val age: Int,
        val gender: String,
        val expired: Boolean
    ) : PresenterModel()

    data class Blog(
        val id: Int,
        val title: String,
        val subTitle: String,
        val image: String,
        val createdDate: String,
        val tag: String
    ) : PresenterModel()
}
