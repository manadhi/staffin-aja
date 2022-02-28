package com.udhipe.staffinaja.domain.candidate

data class Address(
    val id: Int,
    val address: String,
    val city: String,
    val state: String,
    val zipCode: Int
)