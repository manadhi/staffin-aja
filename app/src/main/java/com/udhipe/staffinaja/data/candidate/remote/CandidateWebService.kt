package com.udhipe.staffinaja.data.candidate.remote

import retrofit2.Response
import retrofit2.http.GET

interface CandidateWebService {
    @GET("candidates")
    suspend fun getAllCandidate(): Response<CandidateResponse>

    @GET("emails")
    suspend fun getAllContact(): Response<ContactResponse>

    @GET("address")
    suspend fun getAllAddress(): Response<AddressResponse>

    @GET("experiences")
    suspend fun getAllStatus(): Response<StatusResponse>
}