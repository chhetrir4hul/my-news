package com.rahul.mynews.ui.news.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rahul.mynews.databinding.FragmentNewsDetailBinding
import com.rahul.mynews.util.DateTimeUtil
import com.rahul.mynews.util.GlideImageLoader

class NewsDetailFragment : Fragment() {
    lateinit var mBinding: FragmentNewsDetailBinding

    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        val article = args.article

        GlideImageLoader(mBinding.ivImage).load(article?.urlToImage)
        mBinding.tvTitle.text = article?.title ?: "-"
        mBinding.tvAuthor.text = article?.author ?: "-"
        mBinding.tvPublishedDate.text =
            article?.publishedAt?.let { DateTimeUtil.getFormattedDate(it) }
        mBinding.tvContent.text = article?.content

        return mBinding.root
    }
}