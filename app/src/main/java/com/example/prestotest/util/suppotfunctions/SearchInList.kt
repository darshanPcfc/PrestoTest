package com.example.prestotest.util.suppotfunctions

import com.example.prestotest.ui.fragment.data.Flight
import com.example.prestotest.ui.fragment.data.Stock

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: utility class for searching in stock and flight data class
 * How to call: classname.method()
 *
 */
class SearchInList {
    companion object {
        @JvmStatic
        fun search(
            stockList: ArrayList<Stock>,
            flightList: ArrayList<Flight>,
            product: String,
            location: String
        ): ArrayList<Flight> {
            val resultStock: ArrayList<Stock> = ArrayList()

            if (stockList.size > 0) {
                for (stock in stockList) {
                    if (stock.ingredient.equals(
                            product,
                            ignoreCase = true
                        ) && stock.stock_available.equals("true", ignoreCase = true)
                    ) {
                        resultStock.add(stock)
                    } else {
                        resultStock.remove(stock)
                    }
                }
            }
            if (resultStock.size > 0) {
                return searchFlight(resultStock, flightList, location)
            } else {
                return ArrayList<Flight>()
            }
        }

        private fun searchFlight(
            resultStock: ArrayList<Stock>,
            flighList: ArrayList<Flight>,
            location: String
        ): ArrayList<Flight> {
            val resultFlight: ArrayList<Flight> = ArrayList()
            if (resultStock.size > 0 && flighList.size > 0) {
                for (stock in resultStock) {
                    for (flight in flighList) {
                        if (stock.location.equals(
                                flight.departing_city,
                                ignoreCase = true
                            ) && flight.arriving_city.equals(location, ignoreCase = true)
                        ) {
                            resultFlight.add(flight)
                        } else {
                            resultFlight.remove(flight)
                        }
                    }
                }
            }
            return resultFlight
        }
    }
}