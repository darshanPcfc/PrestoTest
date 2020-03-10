package com.example.prestotest.util.suppotfunctions

import com.example.prestotest.ui.fragment.data.Flight
import com.example.prestotest.util.constants.Constants
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

        //used for setting priority for each day based current day
        //according to priority days would be sorted in list
        fun fetchInt(day: String): Int {
            val calendar: Calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            val count: Int = calendar.get(Calendar.DAY_OF_WEEK)
            when (day) {
                Constants.DaysOfWeekString.SUNDAY -> if (1 < count) {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_SUNDAY
                } else {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_SUNDAY
                }
                Constants.DaysOfWeekString.MONDAY ->
                    if (2 < count) {
                        return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_MONDAY
                    } else {
                        return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_MONDAY
                    }
                Constants.DaysOfWeekString.TUESDAY ->
                    if (3 < count) {
                        return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_TUESDAY
                    } else {
                        return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_TUESDAY
                    }
                Constants.DaysOfWeekString.WEDNESDAY -> if (4 < count) {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_WEDNESDAY
                } else {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_WEDNESDAY
                }
                Constants.DaysOfWeekString.THURSDAY -> if (5 < count) {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_THURSDAY
                } else {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_THURSDAY
                }
                Constants.DaysOfWeekString.FRIDAY -> if (6 < count) {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_FRIDAY
                } else {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_FRIDAY
                }
                Constants.DaysOfWeekString.SATURDAY-> if (7 < count) {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT + Constants.PrioritySearchDaysConstants.PRIORITY_SATURDAY
                } else {
                    return Constants.PrioritySearchDaysConstants.PRIORITY_CONSTANT - Constants.PrioritySearchDaysConstants.PRIORITY_SATURDAY

                }
                else -> return 1
            }
        }

        //sort array based on price
        fun sortByCost(flightList: ArrayList<Flight>): ArrayList<Flight> {
            return ArrayList(flightList.sortedWith(compareBy({ it.price.toInt() })))
        }

        //sort array based on day of week
        fun sortByDay(flightList: ArrayList<Flight>): ArrayList<Flight> {
            for (flight in flightList) {
                flight.arrival_time = TimeFormatter.formatTimeToTwelveHours(flight.arrival_time)
                flight.arrival_day_int = fetchInt(flight.arrival_day)
            }
            return ArrayList(flightList.sortedWith(compareBy { it.arrival_day_int }))
        }
    }
}