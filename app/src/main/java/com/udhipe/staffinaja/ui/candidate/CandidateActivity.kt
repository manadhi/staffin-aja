package com.udhipe.staffinaja.ui.candidate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.udhipe.staffinaja.R
import com.udhipe.staffinaja.databinding.ActivityCandidateBinding
import com.udhipe.staffinaja.databinding.ActivityHomeBinding
import com.udhipe.staffinaja.ui.common.PresenterModel
import com.udhipe.staffinaja.ui.home.HomeViewModel
import com.udhipe.staffinaja.util.GlideManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class CandidateActivity : AppCompatActivity() {
    companion object {
        const val CANDIDATE_ID = "candidate_id"
        const val CANDIDATE_DATA = "candidate_presenter_model"
    }

    private lateinit var binding: ActivityCandidateBinding
    private val candidateViewModel: CandidateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandidateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
//        setListener()
    }

    private fun setView() {
        val candidatePresenterModel =
            intent.getParcelableExtra<PresenterModel.Candidate>(CANDIDATE_DATA)
        if (candidatePresenterModel != null) {
            binding.tvCandidateId.text = getString(R.string.candidate_id, candidatePresenterModel.id)
            GlideManager.loadImageResource(this@CandidateActivity, candidatePresenterModel.image, binding.imgCandidate)
            if (candidatePresenterModel.expired) {
                binding.tvCandidateExpired.visibility = View.VISIBLE
            } else {
                binding.tvCandidateExpired.visibility = View.GONE
            }
            binding.tvCandidateName.text = candidatePresenterModel.name
            binding.tvCandidateAge.text = getString(R.string.candidate_age, candidatePresenterModel.age)
            binding.tvCandidateGender.text = candidatePresenterModel.gender
        }


        val candidateId = intent.getIntExtra(CANDIDATE_ID, -1)
    }

//    private fun setListener() {
//
//    }
}