package com.example.prestotest.util.suppotfunctions

import com.example.prestotest.ui.fragment.data.Flight
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: sorting the list in ascending order with respect to today's day and price
 * How to call: classname.method()
 *
 */
class SortViewList {
    companion object {
        @JvmStatic
        fun sortList(flightList: ArrayList<Flight>): ArrayList<Flight> {
            return sortByDay(sortByCost(flightList))
        }

        fun fetchInt(day: String): Int {
            val calendar: Calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            val count: Int = calendar.get(Calendar.DAY_OF_WEEK)
            when (day) {
                "sunday" -> if (1 < count) {
                    //day has passed
                    return 100 + 7
                } else {
                    //day has not passed
                    return 100 -7
                }
                "monday" ->
                    if (2 < count) {
                        return 100 + 6
                    } else {
                        return 100  - 6
                    }
                "tuesday" ->
                    if (3 < count) {
                        return 100 + 5
                    } else {
                        return 100 - 5
                    }
                "wednesday" -> if (4 < count) {
                    return 100 + 4
                } else {
                    return 100 - 4
                }
                "thursday" -> if (5 < count) {
                    return 100 + 3
                } else {
                    return 100 - 3
                }
                "friday" -> if (6 < count) {
                    return 100 + 2
                } else {
                    return 100 - 2
                }
                "saturday" -> if (7 < count) {
                    return 100 + 1
                } else {
                    return 100 - 1
                }
                else -> return 1
            }
        }

        fun fetchDay(day: Int): String {
            when (day) {
                1 -> return "Monday"
                2 -> return "Tuesday"
                3 -> return "Wednesday"
                4 -> return "Thursday"
                5 -> return "Friday"
                6 -> return "Saturday"
                7 -> return "Saturday"
                else -> return "Monday"
            }
        }

        fun sortByCost(flightList: ArrayList<Flight>): ArrayList<Flight> {
            return ArrayList(flightList.sortedWith(compareBy({ it.price.toInt() })))
        }

        fun sortByDay(flightList: ArrayList<Flight>): ArrayList<Flight> {
            for (flight in flightList) {
                flight.arrival_time = TimeFormatter.formatTimeToTwelveHours(flight.arrival_time)
                flight.arrival_day_int = fetchInt(flight.arrival_day)
            }
            return  ArrayList(flightList.sortedWith(compareBy { it.arrival_day_int }))
        }
    }
}