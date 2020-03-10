package com.example.prestotest.ui.activities.mainactivity

import android.os.Bundle
import com.example.prestotest.BR
import com.example.prestotest.R
import com.example.prestotest.base.BaseActivity
import com.example.prestotest.databinding.ActivityMainBinding
import com.example.prestotest.ui.activities.mainactivity.viewmodel.IMainActivityObserver
import com.example.prestotest.ui.activities.mainactivity.viewmodel.MainActivityViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: for main ui
 * How to call: register in manifest file,
 * Useful parameter: injection of repositories,viewmodel,appinjection
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),
    IMainActivityObserver {

    override val viewModel: MainActivityViewModel by viewModel()
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.activity_main
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = this.viewDataBinding!!
        viewModel.setNavigator(this)
    }
}
