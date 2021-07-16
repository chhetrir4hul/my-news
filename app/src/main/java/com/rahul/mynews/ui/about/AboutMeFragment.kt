package com.rahul.mynews.ui.about

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.rahul.mynews.BuildConfig
import com.rahul.mynews.databinding.FragmentAboutMeBinding

class AboutMeFragment : Fragment() {
    lateinit var mBinding: FragmentAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAboutMeBinding.inflate(inflater, container, false)

        mBinding.tvAppVersion.text = BuildConfig.VERSION_NAME

        return mBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}