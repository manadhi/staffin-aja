package com.udhipe.staffinaja.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

sealed class CombinedLiveData {
    class CombineTwo<FirstType, SecondType, TargetType>(
        firstData: LiveData<FirstType>,
        secondData: LiveData<SecondType>,
        private val combineData: (FirstType?, SecondType?) -> TargetType
    ) : MediatorLiveData<TargetType>() {

        private var dataOne: FirstType? = null
        private var dataTwo: SecondType? = null

        init {
            super.addSource(firstData) {
                dataOne = it
                value = combineData(dataOne, dataTwo)
            }
            super.addSource(secondData) {
                dataTwo = it
                value = combineData(dataOne, dataTwo)
            }
        }

        override fun <S : Any?> addSource(source: LiveData<S>, onChanged: Observer<in S>) {
            throw UnsupportedOperationException()
        }

        override fun <S : Any?> removeSource(toRemote: LiveData<S>) {
            throw UnsupportedOperationException()
        }

        //        override fun onActive() {
//            super.onActive()
//
//            subscribeTo(
//                firstSource = firstSource,
//                secondSource = secondSource,
//                distinctUntilChanged = distinctUntilChanged,
//                merging = merging
//            )
//        }
//
//        override fun onInactive() {
//            removeSource(firstSource)
//            removeSource(secondSource)
//
//            super.onInactive()
//        }
    }
}
