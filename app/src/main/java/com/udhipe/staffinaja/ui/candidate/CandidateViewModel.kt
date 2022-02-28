package com.udhipe.staffinaja.ui.candidate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udhipe.staffinaja.domain.candidate.CandidateUseCase
import com.udhipe.staffinaja.ui.common.AddressPresenterModel
import com.udhipe.staffinaja.ui.common.ContactPresenterModel
import com.udhipe.staffinaja.ui.common.StatusPresenterModel
import com.udhipe.staffinaja.util.CandidateDataMapper
import kotlinx.coroutines.launch

class CandidateViewModel(private val candidateUseCase: CandidateUseCase) : ViewModel() {
    private var mContact = MutableLiveData<ContactPresenterModel>()
    private var mAddress = MutableLiveData<AddressPresenterModel>()
    private var mStatus = MutableLiveData<StatusPresenterModel>()

    val contact: LiveData<ContactPresenterModel>
        get() = mContact

    val address: LiveData<AddressPresenterModel>
        get() = mAddress

    val status: LiveData<StatusPresenterModel>
        get() = mStatus

    fun getContactById(id: Int) {
        viewModelScope.launch {
            try {
                val contact = candidateUseCase.getContactById(id)
                if (contact != null) {
                    mContact.postValue(CandidateDataMapper.mapContactDomainModelToPresenter(contact))
                }
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
            }
        }
    }

    fun getAddressById(id: Int) {
        viewModelScope.launch {
            try {
                val address = candidateUseCase.getAddressById(id)
                if (address != null) {
                    mAddress.postValue(CandidateDataMapper.mapAddressDomainModelToPresenter(address))
                }
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
            }
        }
    }

    fun getStatusById(id: Int) {
        viewModelScope.launch {
            try {
                val status = candidateUseCase.getStatusById(id)
                if (status != null) {
                    mStatus.postValue(CandidateDataMapper.mapStatusDomainModelToPresenter(status))
                }
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
            }
        }
    }
}