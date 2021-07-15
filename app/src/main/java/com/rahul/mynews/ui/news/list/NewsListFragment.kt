package com.rahul.mynews.ui.news.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahul.mynews.databinding.FragmentNewsListBinding

class NewsListFragment : Fragment() {

    lateinit var mBinding: FragmentNewsListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsListBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}