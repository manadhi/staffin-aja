package com.udhipe.staffinaja.ui.candidate

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.udhipe.staffinaja.R
import com.udhipe.staffinaja.databinding.ActivityCandidateBinding
import com.udhipe.staffinaja.ui.common.PresenterModel
import com.udhipe.staffinaja.util.GlideManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.content.Intent
import android.net.Uri


class CandidateActivity : AppCompatActivity() {
    companion object {
        const val CANDIDATE_ID = "candidate_id"
        const val CANDIDATE_DATA = "candidate_presenter_model"
    }

    private lateinit var binding: ActivityCandidateBinding
    private val candidateViewModel: CandidateViewModel by viewModel()

    private lateinit var candidateEmail: String
    private lateinit var candidatePhone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCandidateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
        setListener()
    }

    private fun setView() {
        val candidatePresenterModel =
            intent.getParcelableExtra<PresenterModel.Candidate>(CANDIDATE_DATA)
        if (candidatePresenterModel != null) {
            binding.tvCandidateId.text =
                getString(R.string.candidate_id, candidatePresenterModel.id)
            GlideManager.loadImageResource(
                this@CandidateActivity,
                candidatePresenterModel.image,
                binding.imgCandidate
            )
            if (candidatePresenterModel.expired) {
                binding.tvCandidateExpired.visibility = View.VISIBLE
            } else {
                binding.tvCandidateExpired.visibility = View.GONE
            }
            binding.tvCandidateName.text = candidatePresenterModel.name
            binding.tvCandidateAge.text =
                getString(R.string.candidate_age, candidatePresenterModel.age)
            binding.tvCandidateGender.text = candidatePresenterModel.gender
            binding.tvCandidateBirthday.text = candidatePresenterModel.birthday
        }

        val candidateId = intent.getIntExtra(CANDIDATE_ID, -1)
        candidateViewModel.apply {
            getContactById(candidateId)
            getAddressById(candidateId)
            getStatusById(candidateId)

            contact?.observe(this@CandidateActivity, {
                candidateEmail = it.email
                candidatePhone = it.phone
                binding.tvCandidateEmail.text = candidateEmail
                binding.tvCandidatePhone.text = candidatePhone
            })

            address?.observe(this@CandidateActivity, {
                val fullAddress = it.address + ", " + it.city + ", " + it.state + " " + it.zipCode
                binding.tvCandidateAddress.text = fullAddress
            })

            status?.observe(this@CandidateActivity, {
                binding.tvCandidateCompany.text = it.companyName
                binding.tvCandidateJobTitle.text = it.jobTitle
                binding.tvCandidateIndustry.text = it.industry
                binding.tvCandidateStatus.text = it.status
            })
        }
    }

    private fun setListener() {
        binding.tvCandidateEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = getString(R.string.email_message_type)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(candidateEmail))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body))
            startActivity(emailIntent)

            try {
                startActivity(emailIntent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this@CandidateActivity,
                    getString(R.string.no_suitable_app),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.tvCandidatePhone.setOnClickListener {
            Toast.makeText(this@CandidateActivity, candidatePhone, Toast.LENGTH_SHORT).show()
        }
    }
}