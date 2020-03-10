package com.example.prestotest.ui.activities.mainactivity.viewmodel

import android.app.Application
import com.example.prestotest.base.BaseViewModel
import com.example.prestotest.ni.retrofit.MainApiInterface

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: pass in your base activity rest base activity will take care,
 *          BaseViewmodel will provide observable which will attch your viewmodel with UI
 * How to call: inject through viewmodel injection and use that injection to access functions of this class
 * Useful parameter: application context and apiinterface context would be provided through koin injections
 */
class MainActivityViewModel(application: Application, val mainApiInterface: MainApiInterface) :
    BaseViewModel<IMainActivityObserver>() {

}