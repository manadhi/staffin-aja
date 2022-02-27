package com.udhipe.staffinaja.domain.candidate

import com.google.gson.annotations.SerializedName

data class Address(
    val id: Int,
    val address: String,
    val city: String,
    val state: String,
    val zipCode: Int
)