package com.letsgotoperfection.whatshotonsoundcloud.extentions

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author hossam.
 */
object DateFormat {
    fun formatStringDate(stringDate: String): String {

        val outputDate = SimpleDateFormat("MMM dd, yy", Locale.US)
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val date: Date
        try {
            date = sdf.parse(stringDate)
            return outputDate.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return stringDate
    }
}

inline fun <T : Any, R> whenNotNull(input: T?, callback: (T) -> R): R? {
    return input?.let(callback)
}