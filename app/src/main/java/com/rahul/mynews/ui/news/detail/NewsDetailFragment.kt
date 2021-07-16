package com.rahul.mynews.ui.news.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.rahul.mynews.R
import com.rahul.mynews.data.Article
import com.rahul.mynews.databinding.FragmentNewsDetailBinding
import com.rahul.mynews.util.DateTimeUtil
import com.rahul.mynews.util.GlideImageLoader
import com.rahul.mynews.util.ShareUtil

class NewsDetailFragment : Fragment() {
    lateinit var mBinding: FragmentNewsDetailBinding

    private val args: NewsDetailFragmentArgs by navArgs()

    private var article: Article? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentNewsDetailBinding.inflate(inflater, container, false)

        article = args.article

        GlideImageLoader(mBinding.ivImage).load(article?.urlToImage)
        mBinding.tvTitle.text = article?.title ?: "-"
        mBinding.tvAuthor.text = article?.author ?: "-"
        mBinding.tvPublishedDate.text =
            article?.publishedAt?.let { DateTimeUtil.getFormattedDate(it) }
        mBinding.tvContent.text = article?.content

        return mBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                this.context?.let { ShareUtil.shareUrl(it, article?.url) }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}