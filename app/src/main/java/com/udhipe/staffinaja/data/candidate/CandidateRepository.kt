package com.udhipe.staffinaja.data.candidate

import com.udhipe.staffinaja.data.candidate.remote.ICandidateRemoteDataSource
import com.udhipe.staffinaja.domain.candidate.*
import com.udhipe.staffinaja.util.CandidateDataMapper

class CandidateRepository(private val candidateRemoteDataSource: ICandidateRemoteDataSource) :
    ICandidateRepository {
    override suspend fun getAllCandidate(): List<Candidate> {
        return CandidateDataMapper.mapCandidateNetworkModelToDomain(candidateRemoteDataSource.getAllCandidate())
    }

    override suspend fun getAllContact(): List<Contact> {
        return CandidateDataMapper.mapContactNetworkModelToDomain(candidateRemoteDataSource.getAllContact())
    }

    override suspend fun getAllAddress(): List<Address> {
        return CandidateDataMapper.mapAddressNetworkModelToDomain(candidateRemoteDataSource.getAllAddress())
    }

    override suspend fun getAllStatus(): List<Status> {
        return CandidateDataMapper.mapStatusNetworkModelToDomain(candidateRemoteDataSource.getAllStatus())
    }
}