package com.rahul.mynews.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtil {

    fun getFormattedDate(stringDate: String): String {
        var sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        val date: Date?
        try {
            date = sdf.parse(stringDate)
        } catch (exception: ParseException) {
            return "-"
        }
        sdf = SimpleDateFormat("dd MMM, yyyy HH:mm", Locale.getDefault())
        return sdf.format(date!!)
    }
}