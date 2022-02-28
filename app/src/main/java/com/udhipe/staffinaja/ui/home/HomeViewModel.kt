package com.udhipe.staffinaja.ui.home

import androidx.lifecycle.*
import com.udhipe.staffinaja.domain.blog.BlogUseCase
import com.udhipe.staffinaja.domain.candidate.CandidateUseCase
import com.udhipe.staffinaja.util.BlogDataMapper
import com.udhipe.staffinaja.util.CandidateDataMapper
import kotlinx.coroutines.launch

class HomeViewModel(
    private val candidateUseCase: CandidateUseCase,
    private val blogUseCase: BlogUseCase
) : ViewModel() {

    val combinedCandidateBlog: LiveData<MutableList<PresenterModel>>
        get() = mCombinedCandidateBlog

    // for keeping original data
    private val originalCandidateBlogList = mutableListOf<PresenterModel>()

    // for expose data to view
    private val mCombinedCandidateBlog = MutableLiveData<MutableList<PresenterModel>>()

    init {
        mCombinedCandidateBlog.value = ArrayList()
    }

    fun getCandidateBlogList() {
        originalCandidateBlogList.clear()
        mCombinedCandidateBlog.value?.clear()
        getCandidateList()
        getBlogList()
    }

    fun filterCandidateBlogList(keyword: String) {
        if (keyword == "") {
            mCombinedCandidateBlog.value?.clear()
            mCombinedCandidateBlog.value = originalCandidateBlogList
        } else {
            val filteredCandidateBlogList = mutableListOf<PresenterModel>()
            for (presenterModel: PresenterModel in originalCandidateBlogList) {
                val wordToFilter = when (presenterModel) {
                    is PresenterModel.Blog -> presenterModel.title
                    is PresenterModel.Candidate -> presenterModel.name
                }

                if (wordToFilter.contains(keyword, ignoreCase = true)) {
                    filteredCandidateBlogList.add(presenterModel)
                }
            }

            mCombinedCandidateBlog.value?.clear()
            mCombinedCandidateBlog.value = filteredCandidateBlogList
        }
    }

    private fun getCandidateList() {
        viewModelScope.launch {
            try {
                val candidateList = candidateUseCase.getAllCandidate()
                val candidatePresenterModelList =
                    CandidateDataMapper.mapCandidateDomainModelToPresenter(candidateList)
                originalCandidateBlogList.addAll(candidatePresenterModelList)
                mCombinedCandidateBlog.value?.addAll(candidatePresenterModelList)
                mCombinedCandidateBlog.value = mCombinedCandidateBlog.value
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
            }
        }
    }

    private fun getBlogList() {
        viewModelScope.launch {
            try {
                val blogList = blogUseCase.getAllBlog()
                val blogPresenterModelList = BlogDataMapper.mapBlogDomainModelToPresenter(blogList)
                originalCandidateBlogList.addAll(blogPresenterModelList)
                mCombinedCandidateBlog.value?.addAll(blogPresenterModelList)
                mCombinedCandidateBlog.value = mCombinedCandidateBlog.value
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
            }
        }
    }
}