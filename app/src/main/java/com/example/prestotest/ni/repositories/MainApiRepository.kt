package com.example.prestotest.ni.repositories

import android.content.Context
import com.example.prestotest.ni.retrofit.MainApiInterface

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: call group of api for main module
 * How to call: inject it through coin
 * Useful parameter: context and apiinterface instance to call api
 */
class MainApiRepository(private val context: Context, val mainApiInterceptor: MainApiInterface)  {
}