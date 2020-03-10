package com.example.prestotest.ui.fragment.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: serialized for fetching flight object from JSON File,Model class used as data model
 * How to call: with object
 *
 */
data class Stock(
    @SerializedName("location") var location: String,
    @SerializedName("ingredient") var ingredient: String,
    @SerializedName("stock_available") var stock_available: String
) {
}