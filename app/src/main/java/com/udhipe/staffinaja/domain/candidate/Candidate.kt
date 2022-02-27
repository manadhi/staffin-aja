package com.udhipe.staffinaja.domain.candidate

import java.util.Date

data class Candidate(
    val id: Int,
    val name: String,
    val gender: Gender,
    val photo: String,
    val birthday: Date,
    val expired: Date
)