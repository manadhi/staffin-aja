package com.udhipe.staffinaja.ui.candidate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.udhipe.staffinaja.R
import com.udhipe.staffinaja.databinding.ActivityCandidateBinding
import com.udhipe.staffinaja.databinding.ActivityHomeBinding
import com.udhipe.staffinaja.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CandidateActivity : AppCompatActivity() {
    companion object {
        const val CANDIDATE_ID = "candidate_id"
        const val CANDIDATE_DATA = "candidate_presenter_model"
    }

    private lateinit var binding: ActivityCandidateBinding
//    private val candidateViewModel: CandidateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandidateBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setView()
//        setListener()
    }

//    private fun setView() {
//        TODO("Not yet implemented")
//    }
//
//    private fun setListener() {
//        TODO("Not yet implemented")
//    }
}