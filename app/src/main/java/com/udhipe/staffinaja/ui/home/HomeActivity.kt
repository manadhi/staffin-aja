package com.udhipe.staffinaja.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.udhipe.staffinaja.databinding.ActivityHomeBinding
import com.udhipe.staffinaja.ui.candidate.CandidateActivity
import com.udhipe.staffinaja.ui.home.HomeAdapter.HomeAdapterInterface

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
    }

    private fun setAdapter() {
        val homeAdapterInterface = object : HomeAdapterInterface {
            override fun onItemClick(itemType: Int, itemId: Int) {
                var intent: Intent? = null
                if (itemType == HomeAdapter.TYPE_CANDIDATE) {
                    intent = Intent(this@HomeActivity, CandidateActivity::class.java)
                    intent.putExtra(CandidateActivity.CANDIDATE_ID, itemId)
                } else {
//                    val intent = Intent(this@HomeActivity, CandidateActivity::class.java)
//                    intent.putExtra(CandidateActivity.CANDIDATE_ID, itemId)
                }

                if (intent != null) {
                    startActivity(intent)
                }
            }
        }
        adapter = HomeAdapter(homeAdapterInterface)
        val linearLayoutManager =
            LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvCandidateBlog.adapter = adapter
        binding.rvCandidateBlog.layoutManager = linearLayoutManager

        // dummy data
        val dummyDataList = mutableListOf<PresenterModel>()

        dummyDataList.add(
            PresenterModel.Candidate(
                0,
                "Jaka Sembung",
                "https://images.unsplash.com/photo-1590505695083-a6ceb62cc40e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTk4fHxodW1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                20,
                "Male",
                false
            )
        )

        dummyDataList.add(
            PresenterModel.Candidate(
                0,
                "Jaka Sembung",
                "https://images.unsplash.com/photo-1590505695083-a6ceb62cc40e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTk4fHxodW1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                20,
                "Male",
                false
            )
        )

        dummyDataList.add(
            PresenterModel.Blog(
                0, "How Handle time when Work from home",
                "Working from home every day may have felt like a novelty six months ago, but for many of us, we’re in it for the long-haul now. Tech companies from Microsoft to Fujitsu are now giving employees the option to work from home permanently.",
                "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1172&q=80",
                "26 February 2022", "tag: work, wfh, pandemic"
            )
        )

        dummyDataList.add(
            PresenterModel.Candidate(
                0,
                "Jaka Sembung",
                "https://images.unsplash.com/photo-1590505695083-a6ceb62cc40e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTk4fHxodW1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                20,
                "Male",
                false
            )
        )

        dummyDataList.add(
            PresenterModel.Blog(
                1, "How Handle time when Work from home",
                "Working from home every day may have felt like a novelty six months ago, but for many of us, we’re in it for the long-haul now. Tech companies from Microsoft to Fujitsu are now giving employees the option to work from home permanently.",
                "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1172&q=80",
                "26 February 2022", "tag: work, wfh, pandemic"
            )
        )

        dummyDataList.add(
            PresenterModel.Candidate(
                0,
                "Jaka Sembung",
                "https://images.unsplash.com/photo-1590505695083-a6ceb62cc40e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTk4fHxodW1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                20,
                "Male",
                false
            )
        )

        dummyDataList.add(
            PresenterModel.Candidate(
                0,
                "Jaka Sembung",
                "https://images.unsplash.com/photo-1590505695083-a6ceb62cc40e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTk4fHxodW1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                20,
                "Male",
                false
            )
        )

        dummyDataList.add(
            PresenterModel.Candidate(
                0,
                "Jaka Sembung",
                "https://images.unsplash.com/photo-1590505695083-a6ceb62cc40e?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTk4fHxodW1hbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                20,
                "Male",
                false
            )
        )

        adapter.setData(dummyDataList)
    }
}