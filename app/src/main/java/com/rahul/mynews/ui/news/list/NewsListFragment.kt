package com.rahul.mynews.ui.news.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rahul.mynews.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {
    private lateinit var mBinding: FragmentNewsListBinding

    private val mViewModel by viewModels<NewsListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsListBinding.inflate(inflater, container, false)
        mViewModel.fetchHeadlines()
        return mBinding.root
    }
}