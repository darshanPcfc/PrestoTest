package com.example.prestotest.ui.fragment.viewmodel

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: observable to attached to listen to UI actions
 * How to call: implement in your class
 * Useful parameter: none
 */
interface ISearchObserver {
    fun searchData(product: String, location: String)
    fun errorLayoutVisible(isError: Boolean)
    fun errorEnterLocationProduct()
}