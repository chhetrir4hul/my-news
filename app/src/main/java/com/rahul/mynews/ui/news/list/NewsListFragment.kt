package com.rahul.mynews.ui.news.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.mynews.R
import com.rahul.mynews.data.Article
import com.rahul.mynews.data.Resource
import com.rahul.mynews.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {
    private lateinit var mBinding: FragmentNewsListBinding

    private val mViewModel by viewModels<NewsListViewModel>()

    private lateinit var mLinearLayoutManager: LinearLayoutManager

    private lateinit var mAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsListBinding.inflate(inflater, container, false)

        mLinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        mViewModel.topHeadlineResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> {
                    mBinding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    mBinding.progressBar.visibility = View.VISIBLE
                    mBinding.rvNews.visibility = View.INVISIBLE
                }
                is Resource.Success -> {
                    mBinding.progressBar.visibility = View.GONE
                    mBinding.rvNews.visibility = View.VISIBLE
                    setupRecycler(it.data?.articles)
                }
            }
        })

        mViewModel.weatherResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    mBinding.progressBar.visibility = View.GONE
                    mBinding.rvNews.visibility = View.VISIBLE
                    mAdapter.setWeatherResponse(it.data)
                    mAdapter.notifyItemChanged(0)
                }
            }
        })

        return mBinding.root
    }

    private fun setupRecycler(articleList: List<Article>?) {
        if (articleList == null)
            return

        mBinding.rvNews.layoutManager = mLinearLayoutManager

        mAdapter = NewsListAdapter(articleList)

        mBinding.rvNews.adapter = mAdapter
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val menuItem = menu.findItem(R.id.action_share)
        menuItem.isVisible = false
    }
}