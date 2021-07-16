package com.rahul.mynews.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.rahul.mynews.R

object WebPageUtil {

    fun openWebPage(context: Context, urlString: String) {
        val webPageUri = Uri.parse(urlString)
        val intent = Intent(Intent.ACTION_VIEW, webPageUri)
        if (context.packageManager.resolveActivity(intent, 0) != null)
            context.startActivity(intent)
        else
            Toast.makeText(
                context,
                context.getText(R.string.error_open_webpage),
                Toast.LENGTH_SHORT
            ).show()
    }
}