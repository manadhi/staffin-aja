package com.udhipe.staffinaja.util

import android.app.Application
import com.udhipe.staffinaja.data.blog.BlogRepository
import com.udhipe.staffinaja.data.blog.remote.BlogRemoteDataSource
import com.udhipe.staffinaja.data.blog.remote.BlogWebService
import com.udhipe.staffinaja.data.blog.remote.IBlogRemoteDataSource
import com.udhipe.staffinaja.data.candidate.CandidateRepository
import com.udhipe.staffinaja.data.candidate.remote.CandidateRemoteDataSource
import com.udhipe.staffinaja.data.candidate.remote.CandidateWebService
import com.udhipe.staffinaja.data.candidate.remote.ICandidateRemoteDataSource
import com.udhipe.staffinaja.domain.blog.BlogInteractor
import com.udhipe.staffinaja.domain.blog.BlogUseCase
import com.udhipe.staffinaja.domain.blog.IBlogRepository
import com.udhipe.staffinaja.domain.candidate.CandidateInteractor
import com.udhipe.staffinaja.domain.candidate.CandidateUseCase
import com.udhipe.staffinaja.domain.candidate.ICandidateRepository
import com.udhipe.staffinaja.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { Network.client.create(CandidateWebService::class.java) }
    single<ICandidateRemoteDataSource> { CandidateRemoteDataSource(get()) }
    single<ICandidateRepository> { CandidateRepository(get()) }
    factory<CandidateUseCase> { CandidateInteractor(get()) }

    single { Network.client.create(BlogWebService::class.java) }
    single<IBlogRemoteDataSource> { BlogRemoteDataSource(get()) }
    single<IBlogRepository> { BlogRepository(get()) }
    factory<BlogUseCase> { BlogInteractor(get()) }

    viewModel { HomeViewModel(candidateUseCase = get(), blogUseCase = get()) }
}

class StaffinAjaApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}