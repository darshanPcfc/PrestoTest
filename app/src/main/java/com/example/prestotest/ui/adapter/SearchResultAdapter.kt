package com.example.prestotest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prestotest.databinding.SearchItemListBinding
import com.example.prestotest.ui.fragment.data.Flight

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: result adapter used to display after search results
 * How to call: setAdater method of recyclerview
 * Useful parameter: result list which need to be populated to every row
 */
class SearchResultAdapter(private val items: ArrayList<Flight>) :
    RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SearchItemListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: SearchItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Flight) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}