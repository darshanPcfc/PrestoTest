package com.example.prestotest.util.suppotfunctions

import android.app.Activity
import com.example.prestotest.ui.fragment.data.SearchList
import com.google.gson.Gson
import java.nio.charset.Charset

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: to fetch data from search.json file present in asset folder
 * How to call: classname.method()
 *
 */
class FetchFromJsonSearch {
    companion object {
        @JvmStatic
        fun search(activity: Activity): SearchList {
            //fetch data
            val json: String
            val fi = activity.getAssets().open("search.json")
            val size = fi.available()
            val buffer = ByteArray(size)
            fi.read(buffer)
            fi.close()
            val gson = Gson()
            json = String(buffer, Charset.defaultCharset())
            return gson.fromJson(json, SearchList::class.java)
        }
    }
}