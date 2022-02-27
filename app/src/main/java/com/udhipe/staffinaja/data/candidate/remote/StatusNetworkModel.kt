package com.udhipe.staffinaja.data.candidate.remote

import com.google.gson.annotations.SerializedName

data class StatusNetworkModel(
    val id: Int,
    val status: String,
    @SerializedName("job_title") val jobTitle: String,
    @SerializedName("company_name") val companyName: String,
    val industry: String
)