package com.udhipe.staffinaja.data.candidate.remote

import com.google.gson.annotations.SerializedName

data class AddressNetworkModel(
    val id: Int,
    val address: String,
    val city: String,
    val state: String,
    @SerializedName("zip_code") val zipCode: Int
)
