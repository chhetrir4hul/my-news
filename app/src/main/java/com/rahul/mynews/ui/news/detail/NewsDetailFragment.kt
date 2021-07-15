package com.rahul.mynews.ui.news.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahul.mynews.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {
    lateinit var mBinding: FragmentNewsDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}