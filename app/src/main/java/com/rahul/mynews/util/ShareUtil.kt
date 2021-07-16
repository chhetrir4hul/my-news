package com.rahul.mynews.util

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.rahul.mynews.R

object ShareUtil {

    fun shareUrl(context: Context, urlString: String?) {
        if (urlString == null) {
            Toast.makeText(context, context.getString(R.string.error_share_url), Toast.LENGTH_SHORT)
                .show()
            return
        }
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, urlString)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(
            sendIntent,
            context.getString(R.string.share_chooser_title)
        )
        context.startActivity(shareIntent)
    }
}