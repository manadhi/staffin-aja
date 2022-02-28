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
//    private val mCandidateList = MutableLiveData<List<PresenterModel.Candidate>>()
//    private val mBlogList = MutableLiveData<List<PresenterModel.Blog>>()
//    private val presenterCandidateList = ArrayList<PresenterModel.Candidate>()
//    private val presenterBlogList = ArrayList<PresenterModel.Blog>()
//    private val presenterModelList = ArrayList<PresenterModel>()


    val combinedCandidateBlog: LiveData<MutableList<PresenterModel>>
        get() = mCombinedCandidateBlog

    private val mCombinedCandidateBlog = MutableLiveData<MutableList<PresenterModel>>()

    init {
        mCombinedCandidateBlog.value = ArrayList()
    }

    private fun getCandidateList() {
        viewModelScope.launch {
            try {
                val candidateList = candidateUseCase.getAllCandidate()

//                presenterCandidateList.addAll(CandidateDataMapper.mapCandidateDomainModelToPresenter(candidateList))
//                presenterModelList.addAll(presenterCandidateList)
//                mCandidateList.value =
//                    CandidateDataMapper.mapCandidateDomainModelToPresenter(candidateList)
                mCombinedCandidateBlog.value?.addAll(
                    CandidateDataMapper.mapCandidateDomainModelToPresenter(
                        candidateList
                    )
                )
                mCombinedCandidateBlog.value = mCombinedCandidateBlog.value
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
//                mCandidateList.value = arrayListOf()
            }
        }
    }

    private fun getBlogList() {
        viewModelScope.launch {
            try {
                val blogList = blogUseCase.getAllBlog()
//                presenterBlogList.addAll(CandidateDataMapper.mapBlogDomainModelToPresenter(blogList))
//                presenterModelList.addAll(presenterBlogList)
//                mBlogList.value = CandidateDataMapper.mapBlogDomainModelToPresenter(blogList)

                mCombinedCandidateBlog.value?.addAll(
                    BlogDataMapper.mapBlogDomainModelToPresenter(
                        blogList
                    )
                )
                mCombinedCandidateBlog.value = mCombinedCandidateBlog.value
            } catch (exception: Exception) {
                val message = exception.message
                print(message)
//                mBlogList.value = arrayListOf()
            }
        }
    }

    fun getCandidateBlogList() {
        mCombinedCandidateBlog.value?.clear()
        getCandidateList()
        getBlogList()
    }
}