package com.example.prestotest.ui.fragment.data

import com.google.gson.annotations.SerializedName

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: serialized for fetching flight object from JSON File,Model class used as data model
 * How to call: with object
 *
 */
data class Flight(
    @SerializedName("departing_city") var departing_city:String,
    @SerializedName("departure_day")  var departure_day:String,
    @SerializedName("departure_time")  var departure_time:String,
    @SerializedName("arriving_city")  var arriving_city:String,
    @SerializedName("arrival_day")  var arrival_day:String,
    @SerializedName("arrival_day_")  var arrival_day_int:Int,
    @SerializedName("arrival_time") var arrival_time:String,
    @SerializedName("price")  var price:String
) {
}