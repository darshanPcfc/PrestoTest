package com.example.prestotest.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prestotest.BR
import com.example.prestotest.R
import com.example.prestotest.base.BaseFragment
import com.example.prestotest.databinding.FragmentSearchBinding
import com.example.prestotest.ui.adapter.SearchResultAdapter
import com.example.prestotest.ui.fragment.data.Flight
import com.example.prestotest.ui.fragment.data.SearchList
import com.example.prestotest.ui.fragment.viewmodel.ISearchObserver
import com.example.prestotest.ui.fragment.viewmodel.SearchViewModel
import com.example.prestotest.util.suppotfunctions.FetchFromJsonSearch
import com.example.prestotest.util.suppotfunctions.SearchInList
import com.example.prestotest.util.suppotfunctions.SortViewList
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.IOException

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: search fragment is used to display search result based on paramenters provided by user in edit text
 * How to call: would be called automatically by nav graph through nav graph andoid architecture
 * Useful parameter: bindingobject,viewmodel and observable
 */
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(),
    ISearchObserver {

    override val viewModel: SearchViewModel by viewModel()
    private lateinit var fragmentSearchBinding: FragmentSearchBinding
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_search

    private var dataAdapter: SearchResultAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSearchBinding = this.viewDataBinding!!
    }

    override fun searchData(product: String, location: String) {
        try {
            //hide keyboard
            hideKeyboard()
            //fetch data from json file
            val searchList: SearchList = FetchFromJsonSearch.search(activity!!)
            //search into data
            var resultFlight: ArrayList<Flight> =
                SearchInList.search(searchList.stockList, searchList.flightList, product, location)
            if (resultFlight.size > 0) {
                resultFlight = SortViewList.sortList(resultFlight)
                errorLayoutVisible(false)
                loadRecyclerviewData(resultFlight)
                dataAdapter!!.notifyDataSetChanged()
            } else {
                //show error message
                errorLayoutVisible(true)
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        } catch (e: Exception) {
            print(e.message)
        }
    }

    override fun errorLayoutVisible(isError: Boolean) {
        rv_display_flights.visibility = View.GONE
        if (isError) {
            tv_error.text = resources.getText(R.string.str_error_no_availability)
            tv_error.visibility = View.VISIBLE
        } else {
            tv_error.visibility = View.GONE
        }
    }

    override fun errorEnterLocationProduct() {
        rv_display_flights.visibility = View.GONE
        tv_error.text = resources.getText(R.string.str_error_enter_details)
        tv_error.visibility = View.VISIBLE
    }

    private fun loadRecyclerviewData(data: ArrayList<Flight>) {
        dataAdapter = SearchResultAdapter(data)
        rv_display_flights.visibility = View.VISIBLE
        rv_display_flights?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dataAdapter
        }
    }
}