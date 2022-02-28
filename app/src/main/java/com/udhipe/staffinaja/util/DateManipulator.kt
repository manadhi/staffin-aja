package com.udhipe.staffinaja.util

import java.text.SimpleDateFormat
import java.util.*

object DateManipulator {
    fun getYear(date: Date): Long {
        val timeDifferent: Long = Date().time - date.time
        val seconds = timeDifferent / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24
        return days / 365
    }

    fun convertDateToString(date: Date, pattern: String): String {
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.ENGLISH)
        return simpleDateFormat.format(date)
    }
}