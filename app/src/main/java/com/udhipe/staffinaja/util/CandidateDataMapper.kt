package com.udhipe.staffinaja.util

import com.udhipe.staffinaja.data.candidate.remote.AddressNetworkModel
import com.udhipe.staffinaja.data.candidate.remote.CandidateNetworkModel
import com.udhipe.staffinaja.data.candidate.remote.ContactNetworkModel
import com.udhipe.staffinaja.data.candidate.remote.StatusNetworkModel
import com.udhipe.staffinaja.domain.candidate.*
import com.udhipe.staffinaja.ui.common.AddressPresenterModel
import com.udhipe.staffinaja.ui.common.ContactPresenterModel
import com.udhipe.staffinaja.ui.common.PresenterModel
import com.udhipe.staffinaja.ui.common.StatusPresenterModel
import java.util.*
import kotlin.collections.ArrayList

object CandidateDataMapper {
    fun mapCandidateNetworkModelToDomain(input: List<CandidateNetworkModel>): List<Candidate> {
        val candidateList = ArrayList<Candidate>()
        input.map {
            val candidate = Candidate(
                id = it.id,
                name = it.name,
                gender = if (it.gender == "m") Gender.MALE else Gender.FEMALE,
                photo = it.photo,
                birthday = Date(it.birthday),
                expired = Date(it.expired)
            )
            candidateList.add(candidate)
        }
        return candidateList
    }

    fun mapContactNetworkModelToDomain(input: List<ContactNetworkModel>): List<Contact> {
        val contactList = ArrayList<Contact>()
        input.map {
            val contact = Contact(
                id = it.id,
                email = it.email,
                phone = it.phone
            )
            contactList.add(contact)
        }
        return contactList
    }

    fun mapAddressNetworkModelToDomain(input: List<AddressNetworkModel>): List<Address> {
        val addressList = ArrayList<Address>()
        input.map {
            val address = Address(
                id = it.id,
                address = it.address,
                city = it.city,
                state = it.state,
                zipCode = it.zipCode
            )
            addressList.add(address)
        }
        return addressList
    }

    fun mapStatusNetworkModelToDomain(input: List<StatusNetworkModel>): List<Status> {
        val statusList = ArrayList<Status>()
        input.map {
            val status = Status(
                id = it.id,
                status = it.status,
                jobTitle = it.jobTitle,
                companyName = it.companyName,
                industry = it.industry
            )
            statusList.add(status)
        }
        return statusList
    }

    fun mapCandidateDomainModelToPresenter(input: List<Candidate>): List<PresenterModel.Candidate> {
        val candidateList = ArrayList<PresenterModel.Candidate>()
        input.map {
            val candidate = PresenterModel.Candidate(
                id = it.id,
                name = it.name,
                image = it.photo,
                age = DateManipulator.getYear(it.birthday).toInt(),
                gender = if (it.gender == Gender.MALE) "Male" else "Female",
                expired = Date().after(it.expired)
            )
            candidateList.add(candidate)
        }
        return candidateList
    }

    fun mapContactDomainModelToPresenter(input: Contact): ContactPresenterModel {
        return ContactPresenterModel(input.email, input.phone)
    }

    fun mapAddressDomainModelToPresenter(input: Address): AddressPresenterModel {
        return AddressPresenterModel(
            input.address,
            input.city,
            input.state,
            input.zipCode.toString()
        )
    }

    fun mapStatusDomainModelToPresenter(input: Status): StatusPresenterModel {
        return StatusPresenterModel(
            input.status,
            input.jobTitle,
            input.companyName,
            input.industry
        )
    }

}