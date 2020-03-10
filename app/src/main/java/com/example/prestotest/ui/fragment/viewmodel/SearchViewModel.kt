package com.example.prestotest.ui.fragment.viewmodel

import android.app.Application
import com.example.prestotest.base.BaseViewModel
import com.example.prestotest.ni.repositories.MainApiRepository
import com.example.prestotest.ni.retrofit.MainApiInterface

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: pass in your base activity rest base fragment will take care,
 *          BaseViewmodel will provide observable which will attch your viewmodel with UI
 * How to call: inject through viewmodel injection and use that injection to access functions of this class
 * Useful parameter: application context and apiinterface context would be provided through koin injections
 */
class SearchViewModel(application: Application, val mainApiInterface: MainApiInterface) :
    BaseViewModel<ISearchObserver>() {
    private val mainApiRepository: MainApiRepository

    init {
        mainApiRepository = MainApiRepository(application, mainApiInterface)
    }

    fun onSearchClicked(product: String, location: String) {
        if (!product.isEmpty() && !location.isEmpty()) {
            getNavigator()?.searchData(product, location)
        } else {
            getNavigator()?.errorEnterLocationProduct()
        }
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        getNavigator()?.errorLayoutVisible(false)
    }
}