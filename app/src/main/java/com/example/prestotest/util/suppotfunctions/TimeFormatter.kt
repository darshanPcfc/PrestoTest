package com.example.prestotest.util.suppotfunctions

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: for formattimg 24 hour time format to 12 hour
 * How to call: classname.method()
 *
 */
class TimeFormatter {
    companion object {
        @SuppressLint("SimpleDateFormat")
        @JvmStatic
        fun formatTimeToTwelveHours(time: String): String {
            try {
                val sdf = SimpleDateFormat("H:mm")
                val dateObj: Date? = sdf.parse(time)
                return SimpleDateFormat("K a").format(dateObj!!)
            } catch (e: ParseException) {
                e.printStackTrace()
                return "null"
            }
        }
    }
}