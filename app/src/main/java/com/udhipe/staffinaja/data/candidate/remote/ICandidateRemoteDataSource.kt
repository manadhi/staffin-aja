package com.udhipe.staffinaja.data.candidate.remote

interface ICandidateRemoteDataSource {
    suspend fun getAllCandidate(): List<CandidateNetworkModel>
    suspend fun getAllContact(): List<ContactNetworkModel>
    suspend fun getAllAddress(): List<AddressNetworkModel>
    suspend fun getAllStatus(): List<StatusNetworkModel>
}