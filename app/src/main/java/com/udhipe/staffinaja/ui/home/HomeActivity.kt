package com.udhipe.staffinaja.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.udhipe.staffinaja.databinding.ActivityHomeBinding
import com.udhipe.staffinaja.ui.blog.BlogActivity
import com.udhipe.staffinaja.ui.candidate.CandidateActivity
import com.udhipe.staffinaja.ui.common.PresenterModel
import com.udhipe.staffinaja.ui.home.HomeAdapter.HomeAdapterInterface
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: HomeAdapter
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        setListener()
    }

    override fun onResume() {
        super.onResume()
        setData()
    }

    private fun setData() {
        homeViewModel.apply {
            getCandidateBlogList()
            combinedCandidateBlog.observe(this@HomeActivity, {
                showData(it)
            })
        }
    }

    private fun showData(combinedCandidateBlogList: MutableList<PresenterModel>) {
        adapter.setData(combinedCandidateBlogList)
    }

    private fun setListener() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // not used
                return false
            }

            override fun onQueryTextChange(keyword: String?): Boolean {
                if (keyword!!.isEmpty()) {
                    homeViewModel.filterCandidateBlogList("")
                } else if (keyword.length >= 2) {
                    homeViewModel.filterCandidateBlogList(keyword)
                }
                return true
            }

        })
    }

    private fun setAdapter() {
        val homeAdapterInterface = object : HomeAdapterInterface {
            override fun onItemClick(
                itemType: Int,
                itemId: Int,
                presenterModel: PresenterModel
            ) {
                val intent: Intent
                if (itemType == HomeAdapter.TYPE_CANDIDATE) {
                    intent = Intent(this@HomeActivity, CandidateActivity::class.java)
                    intent.putExtra(CandidateActivity.CANDIDATE_ID, itemId)
                    intent.putExtra(CandidateActivity.CANDIDATE_DATA, presenterModel as PresenterModel.Candidate)
                } else {
                    intent = Intent(this@HomeActivity, BlogActivity::class.java)
                    intent.putExtra(BlogActivity.BLOG_ID, itemId)
                    intent.putExtra(BlogActivity.BLOG_DATA, presenterModel as PresenterModel.Blog)
                }

                startActivity(intent)
            }
        }
        adapter = HomeAdapter(homeAdapterInterface)
        val linearLayoutManager =
            LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
        binding.rvCandidateBlog.adapter = adapter
        binding.rvCandidateBlog.layoutManager = linearLayoutManager
    }
}