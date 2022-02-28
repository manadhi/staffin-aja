package com.udhipe.staffinaja.data.candidate.remote

class CandidateRemoteDataSource(private val candidateWebService: CandidateWebService) :
    ICandidateRemoteDataSource {
    override suspend fun getAllCandidate(): List<CandidateNetworkModel> {
        val response = candidateWebService.getAllCandidate()
        if (response.isSuccessful) {
            return response.body()?.results ?: ArrayList()
        } else {
            throw Exception("Sorry, an error occurred while requesting data, status error ${response.code()}")
        }
    }

    override suspend fun getAllContact(): List<ContactNetworkModel> {
        val response = candidateWebService.getAllContact()
        if (response.isSuccessful) {
            return response.body()?.results ?: ArrayList()
        } else {
            throw Exception("Sorry, an error occurred while requesting data, status error ${response.code()}")
        }
    }

    override suspend fun getAllAddress(): List<AddressNetworkModel> {
        val response = candidateWebService.getAllAddress()
        if (response.isSuccessful) {
            return response.body()?.results ?: ArrayList()
        } else {
            throw Exception("Sorry, an error occurred while requesting data, status error ${response.code()}")
        }
    }

    override suspend fun getAllStatus(): List<StatusNetworkModel> {
        val response = candidateWebService.getAllStatus()
        if (response.isSuccessful) {
            return response.body()?.results ?: ArrayList()
        } else {
            throw Exception("Sorry, an error occurred while requesting data, status error ${response.code()}")
        }
    }
}