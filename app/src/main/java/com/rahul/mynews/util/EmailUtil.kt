package com.rahul.mynews.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.rahul.mynews.DEVELOPER_EMAIL
import com.rahul.mynews.R

object EmailUtil {

    fun composeNewMessage(context: Context) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(DEVELOPER_EMAIL))
        if (context.packageManager.resolveActivity(intent, 0) != null)
            context.startActivity(
                Intent.createChooser(
                    intent,
                    context.getString(R.string.email_chooser_title)
                )
            )
        else
            Toast.makeText(
                context,
                context.getText(R.string.error_composing_email),
                Toast.LENGTH_SHORT
            ).show()
    }
}