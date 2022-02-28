package com.udhipe.staffinaja.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.udhipe.staffinaja.R
import com.udhipe.staffinaja.databinding.ItemBlogBinding
import com.udhipe.staffinaja.databinding.ItemCandidateBinding
import com.udhipe.staffinaja.util.GlideManager
import java.lang.IllegalArgumentException

class HomeAdapter(private val homeAdapterInterface: HomeAdapterInterface) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    companion object {
        const val TYPE_CANDIDATE = 0
        const val TYPE_BLOG = 1
    }

    private val dataList = mutableListOf<PresenterModel>()

    interface HomeAdapterInterface {
        fun onItemClick(itemType: Int, itemId: Int)
    }


    fun setData(dataList: List<PresenterModel>) {
        this.dataList.apply {
            clear()
            addAll(dataList)
        }
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: ViewBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        private fun bindCandidate(item: PresenterModel.Candidate) {
            val candidateBinding: ItemCandidateBinding = binding as ItemCandidateBinding
            with(candidateBinding) {
                GlideManager.loadImageResource(itemView.context, item.image, imgCandidate)
                tvCandidateName.text = item.name
                tvCandidateGender.text = item.gender
                tvCandidateAge.text = context.resources.getString(
                    R.string.candidate_age, item.age
                )

                if (item.expired) {
                    tvCandidateExpired.visibility = View.VISIBLE
                } else {
                    tvCandidateExpired.visibility = View.GONE
                }

                itemView.setOnClickListener {
                    homeAdapterInterface.onItemClick(TYPE_CANDIDATE, item.id)
                }
            }
        }

        private fun bindBlog(item: PresenterModel.Blog) {
            val blogBinding: ItemBlogBinding = binding as ItemBlogBinding
            with(blogBinding) {
                tvBlogTitle.text = item.title
                tvCreatedDate.text = item.createdDate
                GlideManager.loadImageResource(itemView.context, item.image, imgBlog)
                tvBlogSubTitle.text = item.subTitle
                tvBlogTag.text = item.tag

                itemView.setOnClickListener {
                    homeAdapterInterface.onItemClick(TYPE_BLOG, item.id)
                }
            }
        }

        fun bind(dataModel: PresenterModel) {
            when (dataModel) {
                is PresenterModel.Candidate -> bindCandidate(dataModel)
                is PresenterModel.Blog -> bindBlog(dataModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val binding = when (viewType) {
            TYPE_CANDIDATE -> ItemCandidateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            TYPE_BLOG -> ItemBlogBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            else -> throw IllegalArgumentException("invalid type")
        }

        return HomeViewHolder(binding, parent.context)
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is PresenterModel.Candidate -> TYPE_CANDIDATE
            is PresenterModel.Blog -> TYPE_BLOG
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size


}