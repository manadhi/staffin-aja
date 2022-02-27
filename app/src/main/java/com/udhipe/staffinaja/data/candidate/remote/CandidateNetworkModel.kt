package com.udhipe.staffinaja.data.candidate.remote

data class CandidateNetworkModel(
    val id: Int,
    val name: String,
    val gender: String,
    val photo: String,
    val birthday: Int,
    val expired: Int
)