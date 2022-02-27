package com.udhipe.staffinaja.data.candidate.remote

import com.udhipe.staffinaja.domain.candidate.Address
import com.udhipe.staffinaja.domain.candidate.Candidate
import com.udhipe.staffinaja.domain.candidate.Contact
import com.udhipe.staffinaja.domain.candidate.Status

class CandidateRemoteDataSource: ICandidateRemoteDataSource {
    override suspend fun getAllCandidate(): List<Candidate> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllContact(): List<Contact> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllAddress(): List<Address> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllStatus(): List<Status> {
        TODO("Not yet implemented")
    }
}