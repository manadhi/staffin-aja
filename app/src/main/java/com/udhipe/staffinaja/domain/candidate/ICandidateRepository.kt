package com.udhipe.staffinaja.domain.candidate

interface ICandidateRepository {
    suspend fun getAllCandidate(): List<Candidate>

    suspend fun getAllContact(): List<Contact>

    suspend fun getAllAddress(): List<Address>

    suspend fun getAllStatus(): List<Status>
}