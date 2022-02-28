package com.udhipe.staffinaja.domain.candidate

class CandidateInteractor(private val candidateRepository: ICandidateRepository) :
    CandidateUseCase {
    var candidateList = ArrayList<Candidate>()

    override suspend fun getAllCandidate(): List<Candidate> {
        candidateList.clear()
        candidateList.addAll(candidateRepository.getAllCandidate())
        return candidateList
    }

    override suspend fun getCandidateById(id: Int): Candidate? {
        var result: Candidate? = null
        for (candidate: Candidate in candidateList) {
            if (candidate.id == id) {
                result = candidate
            }
        }
        return result
    }

    override suspend fun getContactById(id: Int): Contact? {
        val contactList = candidateRepository.getAllContact()
        var result: Contact? = null
        for (contact: Contact in contactList) {
            if (contact.id == id) {
                result = contact
            }
        }
        return result
    }

    override suspend fun getAddressById(id: Int): Address? {
        val addressList = candidateRepository.getAllAddress()
        var result: Address? = null
        for (address: Address in addressList) {
            if (address.id == id) {
                result = address
            }
        }
        return result
    }

    override suspend fun getStatusById(id: Int): Status? {
        val statusList = candidateRepository.getAllStatus()
        var result: Status? = null
        for (status: Status in statusList) {
            if (status.id == id) {
                result = status
            }
        }
        return result
    }
}