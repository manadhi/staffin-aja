package com.udhipe.staffinaja.domain.candidate

interface CandidateUseCase {
    suspend fun getAllCandidate(): List<Candidate>

    suspend fun getCandidateById(id: Int): Candidate?

    suspend fun getContactById(id: Int): Contact?

    suspend fun getAddressById(id: Int): Address?

    suspend fun getStatusById(id: Int): Status?
}