package com.example.prestotest.di

import com.example.prestotest.ni.createNetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Darshan Patel 24/02/2020
 * Usage:
 * How to call:
 * Useful parameter:
 */
private val retrofit: Retrofit = createNetworkClient()
//private val MAIN_API_INTERCEPTOR: MainApiInterface = retrofit.create(MainApiInterface::class.java)
val apiInjections = module {
    //single { MAIN_API_INTERCEPTOR }
}