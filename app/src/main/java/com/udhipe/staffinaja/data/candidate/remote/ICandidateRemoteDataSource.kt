package com.udhipe.staffinaja.data.candidate.remote

import com.udhipe.staffinaja.domain.candidate.Address
import com.udhipe.staffinaja.domain.candidate.Candidate
import com.udhipe.staffinaja.domain.candidate.Contact
import com.udhipe.staffinaja.domain.candidate.Status

interface ICandidateRemoteDataSource {
    suspend fun getAllCandidate(): List<Candidate>
    suspend fun getAllContact(): List<Contact>
    suspend fun getAllAddress(): List<Address>
    suspend fun getAllStatus(): List<Status>
}