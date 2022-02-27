package com.udhipe.staffinaja.domain.candidate

data class Status(
    val id: Int,
    val status: String,
    val jobTitle: String,
    val companyName: String,
    val industry: String
)