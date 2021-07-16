package com.rahul.mynews.ui.about

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.rahul.mynews.BuildConfig
import com.rahul.mynews.DEVELOPER_LINKEDIN
import com.rahul.mynews.databinding.FragmentAboutMeBinding
import com.rahul.mynews.util.EmailUtil
import com.rahul.mynews.util.WebPageUtil

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

        mBinding.ivEmail.setOnClickListener { launchGmail() }
        mBinding.ivLinkedin.setOnClickListener { openLinkedIn() }

        return mBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    private fun launchGmail() {
        context?.let { EmailUtil.composeNewMessage(it) }
    }

    private fun openLinkedIn() {
        context?.let { WebPageUtil.openWebPage(it, DEVELOPER_LINKEDIN) }
    }
}