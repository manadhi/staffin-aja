package com.udhipe.staffinaja.domain.mixcandidateblog

interface CandidateBlogUseCase {
    suspend fun getCandidateBlog(): List<Any>

    suspend fun filterCandidateBlog(keyword: String): List<Any>
}